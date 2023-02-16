package com.github.alxmag.intellijfakersupport.lang

import com.github.alxmag.intellijfakersupport.lang.psi.FakerFileType
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.psi.PsiMethod
import com.intellij.testFramework.PsiTestUtil
import com.intellij.testFramework.TestDataPath
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import com.intellij.testFramework.fixtures.DefaultLightProjectDescriptor
import junit.framework.TestCase

@TestDataPath("\$CONTENT_ROOT/testData/")
class RefTest : BasePlatformTestCase() {

    override fun getTestDataPath(): String = "src/test/testData/"

    override fun getProjectDescriptor() = object : DefaultLightProjectDescriptor() {
        override fun configureModule(module: Module, model: ModifiableRootModel, contentEntry: ContentEntry) {
            super.configureModule(module, model, contentEntry)
            PsiTestUtil.addLibrary(
                model,
                "faker-library",
                testDataPath + "lib",
                "datafaker-1.7.0.jar"
            )
        }
    }

    fun testResolveMultipleSegments() {
        val method = resolveRefElement<PsiMethod>("#{name.first<caret>Name}")
        TestCase.assertEquals("firstName", method.name)
        TestCase.assertEquals("net.datafaker.providers.base.Name", method.containingClass?.qualifiedName)
    }

    fun testResolveSingleSegment() {
        val method = resolveRefElement<PsiMethod>("#{na<caret>me}")
        TestCase.assertEquals("name", method.name)
        TestCase.assertEquals("net.datafaker.providers.base.BaseProviders", method.containingClass?.qualifiedName)
    }

    private inline fun <reified T> resolveRefElement(text: String): T {
        myFixture.configureByText(FakerFileType.INSTANCE, text)
        val ref = myFixture.getReferenceAtCaretPositionWithAssertion()
        return ref.resolve() as T
    }
}