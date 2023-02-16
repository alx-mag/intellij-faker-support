package com.github.alxmag.intellijfakersupport.lang.reference

import com.github.alxmag.intellijfakersupport.datafaker.findFakerClass
import com.github.alxmag.intellijfakersupport.lang.name
import com.github.alxmag.intellijfakersupport.lang.psi.FakerFunctionName
import com.github.alxmag.intellijfakersupport.lang.psi.FakerFunctionNameSegment
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.util.PsiUtil
import com.intellij.psi.util.parentOfType

class FakerIdentifierReference(nameSegment: FakerFunctionNameSegment) : PsiReferenceBase<FakerFunctionNameSegment>(nameSegment, TextRange.from(0, nameSegment.text.length), true),
    PsiPolyVariantReference {
    override fun resolve(): PsiElement? {
       return multiResolve(false)
           .takeIf { it.size == 1 }
           ?.first()
           ?.element
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val functionName = myElement.parentOfType<FakerFunctionName>() ?: return emptyArray()
        val identifiersList = functionName.segments
        val mySegmentIndex = identifiersList.indexOf(myElement)
            .takeIf { it != -1 } ?: return emptyArray()

        val project = myElement.project
        val scope = myElement.resolveScope
        // The first parent class is always Faker
        var parentClass = project.findFakerClass(scope)
        var result: Array<PsiMethod> = emptyArray()

        for (i in 0 .. mySegmentIndex) {
            // All refs that are not last segment resolve to no arg method.
            val isNoArgMethod = i != identifiersList.lastIndex

            if (parentClass == null) {
                return emptyArray()
            }

            val identifier = identifiersList[i]

            // TODO normalize method name
            val methodName = identifier.name

            if (isNoArgMethod) {
                val method = findNoArgsMethod(parentClass, methodName) ?: return emptyArray()

                // The next parent class is the method return type
                parentClass = PsiUtil.resolveClassInType(method.returnType)

                result = arrayOf(method)
            } else {
                // Last segment may lead to several methods with the same name
                result = parentClass.findMethodsByName(methodName, true)
                // last segment is always last, so we don't care about searching the next parent class to proceed the chain
            }
        }

        return result.map(::PsiElementResolveResult).toTypedArray()
    }

    private fun findNoArgsMethod(psiClass: PsiClass, name: String): PsiMethod? {
        return psiClass.findMethodsByName(name, true).find {
            it.parameterList.parameters.isEmpty()
        }
    }
}