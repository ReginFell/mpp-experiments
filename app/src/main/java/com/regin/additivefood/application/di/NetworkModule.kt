package com.regin.additivefood.application.di

import com.regin.additivefood.api.Api
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttpConfig
import io.ktor.client.engine.okhttp.OkHttpEngine
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module

val networkModule = module {
    single<HttpLoggingInterceptor> {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
    single<HttpClientEngine> {
        OkHttpEngine(OkHttpConfig().apply {
            addInterceptor(get<HttpLoggingInterceptor>())
        })
    }
    single {
        Api.Builder()
            .baseUrl(getProperty("baseUrl"))
            .language(getProperty("language"))
            .engine(get())
            .appScope(get())
            .build()
    }
}