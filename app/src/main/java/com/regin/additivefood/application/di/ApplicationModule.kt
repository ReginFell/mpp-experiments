package com.regin.additivefood.application.di

import com.regin.additivefood.api.Api
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module.module

val applicationModule = module {
    single { getProperty<CoroutineScope>("appScope") }
    single {
        Api.Builder()
            .baseUrl(getProperty("baseUrl"))
            .language(getProperty("language"))
            .appScope(get())
            .build()
    }
}