package com.regin.additivefood.application.di

import com.regin.additivefood.navigation.AppRouter
import org.koin.dsl.module.module
import ru.terrakok.cicerone.Cicerone

private val cicerone: Cicerone<AppRouter> = Cicerone.create(AppRouter())

val navigationModule = module {
    single { cicerone.navigatorHolder }
    single { cicerone.router as AppRouter }
}