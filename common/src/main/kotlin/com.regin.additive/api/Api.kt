package com.regin.additive.api

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.Url
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async

class Api internal constructor(
    private val baseUrl: String,
    private val coroutineScope: CoroutineScope,
    private val client: HttpClient
) {
    var address = Url("$baseUrl/rfc/rfc1866.txt")

    suspend fun about(): Deferred<String> = coroutineScope.async {
        client.get<String> {
            url(address.toString())
        }
    }

    class Builder {

        private lateinit var baseUrl: String
        private lateinit var coroutineScope: CoroutineScope

        private val client: HttpClient = HttpClient()

        fun baseUrl(baseUrl: String): Builder = apply { this.baseUrl = baseUrl }
        fun coroutineScope(coroutineScope: CoroutineScope): Builder = apply { this.coroutineScope = coroutineScope }

        fun build() = Api(baseUrl, coroutineScope, client)
    }
}