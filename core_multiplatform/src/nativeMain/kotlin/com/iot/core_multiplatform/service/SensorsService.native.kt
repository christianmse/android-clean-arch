package com.iot.core_multiplatform.service

import io.ktor.client.*
import io.ktor.client.engine.cio.*

actual object HttpClientFactory {
    actual fun getHttpClient(): HttpClient {
        return HttpClient(CIO)
    }
}