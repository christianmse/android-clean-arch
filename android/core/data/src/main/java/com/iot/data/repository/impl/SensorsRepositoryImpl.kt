package com.iot.data.repository.impl

import com.iot.data.repository.SensorsRepository
import com.iot.network.remote.SensorsRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn

internal class SensorsRepositoryImpl(
    private val remote: SensorsRemoteDataSource
): SensorsRepository {

    override val sensorsStream: Flow<String>
        get() = flow {
            emit(remote.fetchSensors())
        }.flowOn(Dispatchers.IO)
}