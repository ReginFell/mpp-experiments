package com.regin.additivefood.application

import com.regin.additivefood.api.Api
import org.koin.dsl.module.module

val applicationModule = module {
    single {
        Api.Builder()
            .baseUrl(getProperty("baseUrl"))
            .language(getProperty("language"))
            .appScope(getProperty("appScope"))
            .build()
    }
}