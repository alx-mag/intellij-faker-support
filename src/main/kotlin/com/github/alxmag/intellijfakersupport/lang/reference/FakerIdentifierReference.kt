package com.github.alxmag.intellijfakersupport.lang.reference

import com.github.alxmag.intellijfakersupport.datafaker.findFakerClass
import com.github.alxmag.intellijfakersupport.lang.name
import com.github.alxmag.intellijfakersupport.lang.psi.FakerFunctionName
import com.github.alxmag.intellijfakersupport.lang.psi.FakerFunctionNameSegment
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
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

        val isLastSegment = mySegmentIndex == identifiersList.lastIndex
        for (i in 0 .. mySegmentIndex) {
            if (parentClass == null) {
                return emptyArray()
            }
            val identifier = identifiersList[i]

            // TODO normalize method name
            val methodName = identifier.name

            if (!isLastSegment) { // Non-last segment always leads to a method with no params
                val method = findNoArgsMethod(parentClass, methodName)

                // The next parent class is the method return type
                val returnTypeClass = method?.returnType?.canonicalText ?: return emptyArray()
                parentClass = JavaPsiFacade.getInstance(project).findClass(returnTypeClass, scope)

                result = arrayOf(method)
            } else { // Last segment lead to method and its overloaded versions
                result = parentClass.findMethodsByName(methodName, true)
                // last segment is always last, so we don't care about searching the next parent class to proceed the chain
            }
        }

        return result.map(::PsiElementResolveResult).toTypedArray()
    }

//    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
//        val identifiersList = listOf(myElement)
//
//        val project = myElement.project
//        val scope = myElement.resolveScope
//        var parentClass = project.findFakerClass(scope)
//        var result: Array<PsiMethod> = emptyArray()
//
//        for (i in identifiersList.indices) {
//            if (parentClass == null) {
//                return emptyArray()
//            }
//            val identifier = identifiersList[i]
//
//            // TODO normalize method name
//            val methodName = identifier.text
//
//            val isLastIndex = i == identifiersList.lastIndex
//
//            if (!isLastIndex) {
//                val procedure = findProcedure(parentClass, methodName)
//                val returnTypeClass = procedure?.returnType?.canonicalText ?: return emptyArray()
//                parentClass = JavaPsiFacade.getInstance(project).findClass(returnTypeClass, scope)
//                result = arrayOf(procedure)
//            } else {
//                result = parentClass.findMethodsByName(methodName, true)
//            }
//        }
//
//        return result.map(::PsiElementResolveResult).toTypedArray()
//    }

    private fun findNoArgsMethod(psiClass: PsiClass, name: String): PsiMethod? {
        return psiClass.findMethodsByName(name, true).find {
            it.parameterList.parameters.isEmpty()
        }
    }
}