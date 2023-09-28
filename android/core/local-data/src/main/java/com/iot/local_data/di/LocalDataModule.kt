package com.iot.local_data.di

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.iot.core.local_data.BuildConfig
import com.iot.local_data.local.SensorsPreferencesLocalDataSource
import com.iot.local_data.local.datastore.PreferencesDiskDataSource
import com.iot.local_data.local.datastore.PreferencesDiskDataSourceImpl
import com.iot.local_data.local.impl.SensorsPreferencesLocalDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val localDataModule: Module
    get() = module {
        includes(diskPreferencesModule)
        factoryOf(::SensorsPreferencesLocalDataSourceImpl) { bind<SensorsPreferencesLocalDataSource>() }
    }

private val Context.dataStore by preferencesDataStore(
    name = BuildConfig.DATA_STORE_FILE_NAME
)
private val diskPreferencesModule
    get() = module {
        single {
            androidContext().dataStore
        }
        factoryOf(::PreferencesDiskDataSourceImpl) { bind<PreferencesDiskDataSource>() }
    }