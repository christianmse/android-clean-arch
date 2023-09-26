package com.iot.data.di

import com.iot.data.repository.SensorsRepository
import com.iot.data.repository.impl.SensorsRepositoryImpl
import com.iot.network.di.networkKoinModule
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.bind
import org.koin.dsl.module

val dataKoinModule: Module
    get() = module {
        includes(networkKoinModule)
        singleOf(::SensorsRepositoryImpl) { bind<SensorsRepository>() }
    }
