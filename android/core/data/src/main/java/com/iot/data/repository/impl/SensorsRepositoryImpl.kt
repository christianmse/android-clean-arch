package com.iot.data.repository.impl

import android.util.Log
import com.iot.data.repository.SensorsRepository
import com.iot.local_data.local.SensorsPreferencesLocalDataSource
import com.iot.network.remote.SensorsRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge

internal class SensorsRepositoryImpl(
    private val local: SensorsPreferencesLocalDataSource,
    private val remote: SensorsRemoteDataSource
): SensorsRepository {

    override val sensorsStream: Flow<String>
        get() {
            return merge(
                local.sensorId.map { it ?: "Es null" },
                flow {
                    kotlinx.coroutines.delay(8000)
                    remote.fetchSensors()
                }
            ).flowOn(Dispatchers.IO)
        }
}