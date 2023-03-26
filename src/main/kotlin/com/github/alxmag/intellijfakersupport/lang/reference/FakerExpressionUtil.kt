package com.github.alxmag.intellijfakersupport.lang.reference

import com.github.alxmag.intellijfakersupport.util.hasNoArgs
import com.github.alxmag.intellijfakersupport.util.isNonStatic
import com.github.alxmag.intellijfakersupport.util.isObjectMethod
import com.github.alxmag.intellijfakersupport.util.isPublic
import com.intellij.psi.*

object FakerExpressionUtil {

    val ObjectMethods = setOf(
        "toString",
        "equals",
        "hashCode",
        "notify",
        "wait",
        "notifyAll",
        "finalize",
        "clone",
        "getClass"
    )

    val ValueTypes = setOf(
        CommonClassNames.JAVA_LANG_STRING,

        CommonClassNames.JAVA_LANG_BOOLEAN,
        CommonClassNames.JAVA_LANG_BYTE,
        CommonClassNames.JAVA_LANG_SHORT,
        CommonClassNames.JAVA_LANG_INTEGER,
        CommonClassNames.JAVA_LANG_LONG,
        CommonClassNames.JAVA_LANG_FLOAT,
        CommonClassNames.JAVA_LANG_DOUBLE,
        CommonClassNames.JAVA_LANG_CHARACTER
    )

    // TODO complete this implementation
    fun normalizeMethodName(name: String) = name
}


fun PsiClass.findNoArgsApiMethod(name: String): PsiMethod? {
    return this.findMethodsByName(name, true)
        .find { it.isFakerApiMethod() && it.hasNoArgs() }
}

fun PsiMethod.isFakerApiMethod() = this.isPublic() and
        this.isNonStatic() and
        !this.isConstructor and
        !this.isObjectMethod() and
        !this.isBannedMethod() and
        this.hasExpressionCallableParams() and
        // Exclude inherited methods to prevent duplicates in lookup
        this.findSuperMethods().isEmpty()

// TODO check also containing class
/**
 * Faker methods that are not usable in expressions.
 */
fun PsiMethod.isBannedMethod(): Boolean {
    if (name == "getFaker" || name == "expression") {
        return true
    }

    return false
}

/**
 * @return `true` if all params of the method can be assigned in expression, i.e. can be represented as string.
 * Such params should have 'primitive' types.
 */
private fun PsiMethod.hasExpressionCallableParams(): Boolean {
    return this.parameterList.parameters
        .asSequence()
        .all {
            it.hasValueType()
        }
}

fun PsiParameter.hasValueType() = when (val type = this.type) {
    is PsiEllipsisType -> type.componentType
    else -> type
}.isValueType()

fun PsiType.isValueType(): Boolean {
    return this is PsiPrimitiveType || FakerExpressionUtil.ValueTypes.any { this.equalsToText(it) }
}

fun PsiClass.isValueType(): Boolean {
    val type = this.qualifiedName ?: return false
    return FakerExpressionUtil.ValueTypes.any { type == it }
}