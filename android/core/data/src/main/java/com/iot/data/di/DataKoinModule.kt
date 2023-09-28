package com.iot.data.di

import com.iot.data.repository.SensorsRepository
import com.iot.data.repository.impl.SensorsRepositoryImpl
import com.iot.local_data.di.localDataModule
import com.iot.network.di.networkKoinModule
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.bind
import org.koin.dsl.module

val dataKoinModule: Module
    get() = module {
        includes(localDataModule, networkKoinModule)
        singleOf(::SensorsRepositoryImpl) { bind<SensorsRepository>() }
    }
