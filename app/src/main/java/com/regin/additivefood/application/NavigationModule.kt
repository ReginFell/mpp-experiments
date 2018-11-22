package com.regin.additivefood.application

import com.regin.additivefood.navigation.AppRouter
import org.koin.dsl.module.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

private val cicerone: Cicerone<AppRouter> = Cicerone.create(AppRouter())

val navigationModule = module {
    single { cicerone.navigatorHolder }
    single { cicerone.router as AppRouter }
}