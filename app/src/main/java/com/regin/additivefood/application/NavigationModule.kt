package com.regin.additivefood.application

import org.koin.dsl.module.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

private val cicerone: Cicerone<Router> = Cicerone.create()

val navigationModule = module {
    single { cicerone.navigatorHolder }
    single { cicerone.router }
}