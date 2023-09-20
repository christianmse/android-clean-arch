package com.iot.data.repository

interface SensorsRepository {
    suspend fun getSensors()
}