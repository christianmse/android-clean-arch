package com.iot.local_data.local.datastore

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey

sealed class DiskPreferenceKeys(private val _key: Preferences.Key<*>) {
    val key: Preferences.Key<Any>
        get() = _key as Preferences.Key<Any>

    object SENSOR_ID: DiskPreferenceKeys(intPreferencesKey("MyPreference"))
}