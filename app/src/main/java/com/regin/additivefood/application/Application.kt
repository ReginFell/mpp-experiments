package com.regin.additivefood.application

import com.facebook.stetho.Stetho
import com.regin.additivefood.application.di.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import org.koin.core.KoinProperties
import org.koin.standalone.StandAloneContext.startKoin
import kotlin.coroutines.CoroutineContext
import android.app.Application as AndroidApplication

class Application : AndroidApplication(), CoroutineScope {

    private val job: Job = Job()

    override val coroutineContext: CoroutineContext = job

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)

        startKoin(
            listOf(
                applicationModule,
                networkModule,
                navigationModule,
                databaseModule,
                repositoryModule
            ), KoinProperties(
                useKoinPropertiesFile = true,
                extraProperties = mapOf(
                    Pair("applicationContext", this),
                    Pair("appScope", this as CoroutineScope)
                )
            )
        )
    }
}