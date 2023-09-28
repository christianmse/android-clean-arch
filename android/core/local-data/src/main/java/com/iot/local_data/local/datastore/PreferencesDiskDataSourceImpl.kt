package com.iot.local_data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class PreferencesDiskDataSourceImpl(
    private val dataStore: DataStore<Preferences>
): PreferencesDiskDataSource {
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

    override fun <VALUE> read(preference: DiskPreferenceKeys): Flow<VALUE?> {
        return dataStore.data.map { prefs ->
            prefs[preference.key]
        } as Flow<VALUE?>
    }

}