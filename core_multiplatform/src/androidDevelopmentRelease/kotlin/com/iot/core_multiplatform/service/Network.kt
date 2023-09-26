package com.iot.core_multiplatform.service

import io.ktor.client.*
import io.ktor.client.engine.cio.*

val httpClient: HttpClient = HttpClient(CIO)