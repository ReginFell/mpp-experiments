package com.regin.additivefood.feature.splash

import org.koin.android.scope.ext.android.bindScope
import org.koin.android.scope.ext.android.getOrCreateScope
import org.koin.dsl.module.module
import org.koin.standalone.StandAloneContext.loadKoinModules

const val scopeId = "Splash"

val splashModule = module {
    scope(scopeId) { SplashUseCase(get()) }
    scope(scopeId) { SplashViewModel(get(), get()) }
}

fun SplashFragment.loadModule() {
    loadKoinModules(splashModule)
    bindScope(getOrCreateScope(scopeId))
}