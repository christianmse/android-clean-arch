package com.iot.local_data.local

interface UserPreferencesDiskDataSource: Write, Read {
    suspend fun clearAllPreferences()
}