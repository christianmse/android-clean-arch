package com.iot.common

import com.iot.core.common.BuildConfig

val BuildConfig.isDevelopmentEnvironment: Boolean
    get() = BuildConfig.FLAVOR.equals(other = "development", ignoreCase = true)

val BuildConfig.isProductionEnvironment: Boolean
    get() = BuildConfig.FLAVOR.equals(other = "production", ignoreCase = true)