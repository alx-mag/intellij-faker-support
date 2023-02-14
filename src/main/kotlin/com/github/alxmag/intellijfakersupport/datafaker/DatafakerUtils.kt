package com.github.alxmag.intellijfakersupport.datafaker

import com.intellij.openapi.project.Project
import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.search.GlobalSearchScope

fun Project.findFakerClass(scope: GlobalSearchScope) = JavaPsiFacade.getInstance(this)
    .findClass("net.datafaker.Faker", scope)