package com.github.alxmag.intellijfakersupport.datafaker

import com.intellij.openapi.project.Project
import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.search.GlobalSearchScope

fun Project.findFakerClass(scope: GlobalSearchScope) = JavaPsiFacade.getInstance(this)
    .findClass(DataFakerClasses.FAKER, scope)

object DataFakerClasses {
    const val FAKER = "net.datafaker.Faker"
}