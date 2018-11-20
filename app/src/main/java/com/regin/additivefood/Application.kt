package com.regin.additivefood

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
        startKoin(
            listOf(applicationModule), KoinProperties(
                extraProperties =
                mapOf(Pair("baseUrl", "https://tools.ietf.org"), Pair("coroutineScope", this))
            )
        )
    }
}