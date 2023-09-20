package com.iot.domain.di

import com.iot.data.di.dataKoinModule
import org.koin.core.module.Module
import org.koin.dsl.module

val domainKoinModule: Module
    get() = module {
        includes(dataKoinModule)

    }