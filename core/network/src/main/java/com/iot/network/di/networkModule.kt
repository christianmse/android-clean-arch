package com.iot.network.di

import com.iot.network.remote.SensorsRemoteDataSource
import com.iot.network.remote.impl.SensorsRemoteDataSourceImpl
import kotlinx.serialization.json.Json
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

val interceptorsModule: Module
    get() = module {
        single {
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }
    }

val serializerModule: Module
    get() = module {
        single<Json> {
            Json {
                prettyPrint = true
            }
        }
    }

val remoteDataSourceModule: Module
    get() = module {
        factory<SensorsRemoteDataSource> { SensorsRemoteDataSourceImpl(get()) }
    }

fun provideRetrofit(client: OkHttpClient, jsonDeserializer: Json, urlBase: String): Retrofit {
    val contentType = "application/json".toMediaType()
    return Retrofit.Builder()
        .baseUrl(urlBase)
        .client(client)
        .addConverterFactory(jsonDeserializer.asConverterFactory(contentType))
        .build()
}

inline fun <reified T> provideApi(retrofit: Retrofit): T = retrofit.create(T::class.java)