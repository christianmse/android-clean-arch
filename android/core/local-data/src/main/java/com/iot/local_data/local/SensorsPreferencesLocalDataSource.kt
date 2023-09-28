package com.iot.local_data.local

import kotlinx.coroutines.flow.Flow

interface SensorsPreferencesLocalDataSource {
    val sensorId: Flow<String?>
}