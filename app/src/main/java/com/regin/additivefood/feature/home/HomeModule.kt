package com.regin.additivefood.feature.home

import org.koin.android.scope.ext.android.bindScope
import org.koin.android.scope.ext.android.getOrCreateScope
import org.koin.dsl.module.module
import org.koin.standalone.StandAloneContext

const val scopeId = "Home"

val homeModule = module {
    scope(scopeId) { HomeViewModel(get()) }
}

fun HomeFragment.loadModule() {
    StandAloneContext.loadKoinModules(homeModule)
    bindScope(getOrCreateScope(scopeId))
}