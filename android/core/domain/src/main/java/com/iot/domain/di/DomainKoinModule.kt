package com.iot.domain.di

import com.iot.data.di.dataKoinModule
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import com.iot.domain.usecase.GetSensorsUseCase

val domainKoinModule: Module
    get() = module {
        includes(dataKoinModule)
        factoryOf(::GetSensorsUseCase)
    }