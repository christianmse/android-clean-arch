package com.iot.network.di

import okhttp3.ConnectionPool
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import java.net.Proxy
import java.util.concurrent.TimeUnit

val httpClientModule: Module
    get() = module {
        single(named(Constants.DEFAULT_CLIENT)) {
            OkHttpClient.Builder()
                .proxy(Proxy.NO_PROXY)
                .connectionPool(
                    ConnectionPool(
                        Constants.DEFAULT_CLIENT_MAX_IDLE_CONNECTIONS,
                        Constants.DEFAULT_CLIENT_KEEP_CONNECTIONS_ALIVE_DURATION_MIN, TimeUnit.MINUTES)
                )
                .dispatcher(Dispatcher().apply {
                    this.maxRequestsPerHost = Constants.DEFAULT_CLIENT_MAX_REQUEST_PER_HOST
                })
                .build()
        }
    }