package com.regin.additivefood

import com.regin.additive.api.Api
import org.koin.dsl.module.module

val applicationModule = module {
    single {
        Api.Builder()
            .baseUrl(getProperty("baseUrl"))
            .coroutineScope(getProperty("coroutineScope"))
            .build()
    }
}