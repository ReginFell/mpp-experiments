package com.regin.additivefood.api

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async

class Api internal constructor(
    private val baseUrl: String,
    private val language: String,
    private val appScope: CoroutineScope,
    private val client: HttpClient
) {

    fun loadAdditives(): Deferred<String> = appScope.async {
        client.get<String> {
            url("$baseUrl/additive/$language.json")
        }
    }

    class Builder {

        private lateinit var baseUrl: String
        private lateinit var language: String
        private lateinit var appScope: CoroutineScope

        private val client: HttpClient = HttpClient()

        fun baseUrl(baseUrl: String): Builder = apply { this.baseUrl = baseUrl }
        fun language(language: String): Builder = apply { this.language = language }
        fun appScope(appScope: CoroutineScope): Builder = apply { this.appScope = appScope }

        fun build() = Api(baseUrl, language, appScope, client)
    }
}