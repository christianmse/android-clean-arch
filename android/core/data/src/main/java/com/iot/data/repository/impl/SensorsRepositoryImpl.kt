package com.iot.data.repository.impl

import com.iot.data.repository.SensorsRepository
import com.iot.network.remote.SensorsRemoteDataSource

internal class SensorsRepositoryImpl(
    private val remote: SensorsRemoteDataSource
): SensorsRepository {
    override suspend fun getSensors() {
        remote.fetchSensors()
    }
}