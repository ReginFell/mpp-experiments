package com.regin.additivefood.application.di

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module.module

val applicationModule = module {
    single { getProperty<Context>("applicationContext") }
    single { getProperty<CoroutineScope>("appScope") }
}