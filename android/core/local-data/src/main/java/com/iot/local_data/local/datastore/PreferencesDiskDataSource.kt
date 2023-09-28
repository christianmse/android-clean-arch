package com.iot.local_data.local.datastore

import com.iot.local_data.local.Read
import com.iot.local_data.local.Write

interface PreferencesDiskDataSource: Write, Read {
    suspend fun clearAllPreferences()
}