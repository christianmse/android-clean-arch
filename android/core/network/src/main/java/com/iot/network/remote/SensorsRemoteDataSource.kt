package com.iot.network.remote

interface SensorsRemoteDataSource {
    suspend fun fetchSensors()
}