package com.iot.jarvis.di

import com.iot.feature.home.di.homeFeatureModule
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module
import com.iot.jarvis.ui.MainActivityViewModel

val appModule: Module
    get() = module {
        includes(homeFeatureModule)
        viewModelOf(::MainActivityViewModel)
    }