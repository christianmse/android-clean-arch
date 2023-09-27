package com.iot.network.di

import com.iot.core_multiplatform.service.SensorsService
import com.iot.network.api.SensorsApi
import com.iot.network.remote.SensorsRemoteDataSource
import com.iot.network.remote.impl.SensorsRemoteDataSourceImpl
import com.iot.network.sensorsBaseUrl
import kotlinx.serialization.json.Json
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

private val interceptorsModule: Module
    get() = module {
        single {
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }
    }

private val serializerModule: Module
    get() = module {
        single<Json> {
            Json {
                prettyPrint = true
                ignoreUnknownKeys = true
            }
        }
    }

private val apiModule: Module
    get() = module {
        single(named(Constants.SENSORS_API)) {
            provideRetrofit(client = get(named(Constants.DEFAULT_CLIENT)), jsonDeserializer = get<Json>(), urlBase = sensorsBaseUrl)
        }

        factory<SensorsApi> { provideApi<SensorsApi>(get(named(Constants.SENSORS_API))) }
    }

val networkKoinModule: Module
    get() = module {
        includes(httpClientModule, apiModule, interceptorsModule, serializerModule)
        factory<SensorsRemoteDataSource> { SensorsRemoteDataSourceImpl(get(), SensorsService) }
    }

private fun provideRetrofit(client: OkHttpClient, jsonDeserializer: Json, urlBase: String): Retrofit {
    val contentType = "application/json".toMediaType()
    return Retrofit.Builder()
        .baseUrl(urlBase)
        .client(client)
        .addConverterFactory(jsonDeserializer.asConverterFactory(contentType))
        .build()
}

private inline fun <reified T> provideApi(retrofit: Retrofit): T = retrofit.create(T::class.java)