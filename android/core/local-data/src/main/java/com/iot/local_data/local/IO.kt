package com.iot.local_data.local

import com.iot.local_data.local.datastore.DiskPreferenceKeys
import kotlinx.coroutines.flow.Flow

interface Write {
    suspend fun <VALUE: Any> write(preference: DiskPreferenceKeys, value: VALUE)
}

interface Read {
    suspend fun <VALUE: Any> read(preference: DiskPreferenceKeys): Flow<VALUE>?
}