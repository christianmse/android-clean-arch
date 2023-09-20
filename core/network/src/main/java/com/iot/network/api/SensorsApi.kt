package com.iot.network.api

import retrofit2.http.GET

interface SensorsApi {
    @GET("/sensors")
    suspend fun getSensors()
}