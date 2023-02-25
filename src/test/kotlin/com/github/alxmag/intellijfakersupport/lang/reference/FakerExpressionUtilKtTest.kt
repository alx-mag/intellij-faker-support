package com.github.alxmag.intellijfakersupport.lang.reference

import com.intellij.psi.PsiJavaFile
import com.intellij.testFramework.TestDataPath
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase
import org.junit.Assert.*

@TestDataPath("\$CONTENT_ROOT/testData/reference")
class FakerExpressionUtilKtTest : LightJavaCodeInsightFixtureTestCase() {

    override fun getTestDataPath(): String = "src/test/testData/reference"

    fun testAssignableParameter() {
        val file = myFixture.configureByFile("MyJavaClass.java") as PsiJavaFile
        val clazz = file.classes.first()
        val method = clazz.methods.first()

        val parameters = method.parameterList.parameters

        // TODO can not check the params because in mock JDK the types are not fully qualified
        println()
    }
}