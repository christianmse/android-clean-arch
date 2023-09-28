package com.iot.local_data.di

import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import com.iot.core.local_data.BuildConfig
import com.iot.local_data.local.UserPreferencesDiskDataSource
import com.iot.local_data.local.datastore.UserPreferencesDiskDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val localDataModule: Module = module {
    includes(diskPreferencesModule)

}

private val diskPreferencesModule = module {
    single {
        PreferenceDataStoreFactory.create {
            androidContext().dataStoreFile(BuildConfig.DATA_STORE_FILE_NAME)
        }
    }

    factory<UserPreferencesDiskDataSource> { UserPreferencesDiskDataSourceImpl(get()) }
}