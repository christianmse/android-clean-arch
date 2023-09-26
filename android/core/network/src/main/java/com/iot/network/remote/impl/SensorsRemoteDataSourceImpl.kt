package com.iot.network.remote.impl

import com.iot.network.api.SensorsApi
import com.iot.network.remote.SensorsRemoteDataSource

internal class SensorsRemoteDataSourceImpl(
    private val api: SensorsApi,
    //private val sensorsService: SensorsService
): SensorsRemoteDataSource {
    override suspend fun fetchSensors() {
        api.getSensors()
    }
}