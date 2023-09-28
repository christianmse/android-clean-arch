package com.iot.local_data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.iot.local_data.local.UserPreferencesDiskDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class UserPreferencesDiskDataSourceImpl(
    private val dataStore: DataStore<Preferences>
): UserPreferencesDiskDataSource {
    override suspend fun clearAllPreferences() {
        dataStore.edit {
            it.clear()
        }
    }

    override suspend fun <VALUE: Any> write(preference: DiskPreferenceKeys, value: VALUE) {
        dataStore.edit { mutablePrefs ->
            mutablePrefs[preference.key] = value
        }
    }

    override suspend fun <VALUE : Any> read(preference: DiskPreferenceKeys): Flow<VALUE>? {
        return dataStore.data.map { prefs ->
            prefs[preference.key]
        } as? Flow<VALUE>
    }

}