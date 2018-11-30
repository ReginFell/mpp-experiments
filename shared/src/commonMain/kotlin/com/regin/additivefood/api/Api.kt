package com.regin.additivefood.api

import com.regin.additivefood.api.model.AdditiveResource
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.observer.ResponseObserver
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.serialization.list
import mu.KotlinLogging

class Api internal constructor(
    private val baseUrl: String,
    private val language: String,
    private val appScope: CoroutineScope,
    private val client: HttpClient
) {

    fun loadAdditives(): Deferred<List<AdditiveResource>> = appScope.async {
        client.get<List<AdditiveResource>> {
            url("$baseUrl/additive/$language.json")
        }
    }

    class Builder {

        private lateinit var baseUrl: String
        private lateinit var language: String
        private lateinit var appScope: CoroutineScope

        private val client: HttpClient = HttpClient {
            install(ResponseObserver) {
                ResponseObserver.Config().onResponse {
                    KotlinLogging.logger {

                    }
                }
            }
            install(JsonFeature) {
                serializer = KotlinxSerializer()
                    .apply {
                        register(AdditiveResource.serializer().list)
                    }
            }
        }

        fun baseUrl(baseUrl: String): Builder = apply { this.baseUrl = baseUrl }
        fun language(language: String): Builder = apply { this.language = language }
        fun appScope(appScope: CoroutineScope): Builder = apply { this.appScope = appScope }

        fun build() = Api(baseUrl, language, appScope, client)
    }
}