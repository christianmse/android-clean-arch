package com.iot.core_multiplatform.service

import io.ktor.client.HttpClient
actual object HttpClientFactory {
    actual fun getHttpClient(): HttpClient {
        return httpClient
    }
}