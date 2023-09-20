package com.iot.network.di

import com.iot.network.api.SensorsApi
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module


private const val sensorsBaseUrl: String = "" //BuildConfig.DEVELOPMENT_BACKEND_URL

val apiModule: Module
    get() = module {
        single(named(Constants.SENSORS_API)) {
            provideRetrofit(client = get(named(Constants.DEFAULT_CLIENT)), jsonDeserializer = get<Json>(), urlBase = sensorsBaseUrl)
        }

        factory<SensorsApi> { provideApi<SensorsApi>(get(named(Constants.SENSORS_API))) }
    }