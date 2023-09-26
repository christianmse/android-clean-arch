package com.iot.network.remote.impl

import com.iot.core_multiplatform.service.SensorsService
import com.iot.network.api.SensorsApi
import com.iot.network.remote.SensorsRemoteDataSource
import kotlinx.coroutines.flow.Flow

internal class SensorsRemoteDataSourceImpl(
    private val api: SensorsApi,
    private val sensorsService: SensorsService
): SensorsRemoteDataSource {
    override suspend fun fetchSensors(): String {
        api.getSensors()
        return sensorsService.getSensors()
    }
}