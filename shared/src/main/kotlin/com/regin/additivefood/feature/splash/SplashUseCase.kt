package com.regin.additivefood.feature.splash

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashUseCase(private val appScope: CoroutineScope) {

    suspend fun start(block: suspend CoroutineScope.() -> Unit) = appScope.launch {
        delay(DELAY_TIME_MS)
        block()
    }

    companion object {
        private const val DELAY_TIME_MS = 2000L
    }
}