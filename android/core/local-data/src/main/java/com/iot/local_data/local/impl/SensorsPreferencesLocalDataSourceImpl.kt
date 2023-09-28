package com.iot.local_data.local.impl

import com.iot.local_data.local.SensorsPreferencesLocalDataSource
import com.iot.local_data.local.datastore.DiskPreferenceKeys
import com.iot.local_data.local.datastore.PreferencesDiskDataSource
import kotlinx.coroutines.flow.Flow

class SensorsPreferencesLocalDataSourceImpl(
    private val diskDataSource: PreferencesDiskDataSource
) : SensorsPreferencesLocalDataSource {
    override val sensorId: Flow<String?>
        get() = diskDataSource.read(DiskPreferenceKeys.SENSOR_ID)
}