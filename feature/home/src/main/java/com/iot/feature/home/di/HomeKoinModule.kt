package com.iot.feature.home.di

import com.iot.domain.di.domainKoinModule
import com.iot.feature.home.ui.viewModel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

val homeFeatureModule: Module
    get() = module {
        includes(domainKoinModule)
        viewModelOf(::HomeViewModel)
    }