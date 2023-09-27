package com.iot.data.repository

import kotlinx.coroutines.flow.Flow

interface SensorsRepository {
    val sensorsStream: Flow<String>
}