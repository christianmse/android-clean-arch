package com.iot.core_multiplatform.service

import io.ktor.client.*
import io.ktor.client.request.*

object SensorsService {
    suspend fun getSensors(): String {
        return with(HttpClientFactory.getHttpClient()) {
            get {  }
            "Hey"
        }
    }
}

expect object HttpClientFactory {
    fun getHttpClient(): HttpClient
}