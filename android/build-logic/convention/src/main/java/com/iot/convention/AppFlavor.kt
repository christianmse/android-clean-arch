package com.iot.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.ProductFlavor
import com.android.build.api.dsl.CommonExtension

enum class FlavorDimension { DEVICE, ENVIRONMENT }

@Suppress("EnumEntryName")
enum class AppFlavor(
    val dimension: FlavorDimension,
    val applicationIdSuffix: String? = null,
    val versionNameSuffix: String? = null
) {
    mobile(
        dimension = FlavorDimension.DEVICE,
        applicationIdSuffix = ".mobile",
        versionNameSuffix = "-mobile"
    ),
    tv(
        dimension = FlavorDimension.DEVICE,
        applicationIdSuffix = ".tv",
        versionNameSuffix = "-tv"
    ),
    development(dimension = FlavorDimension.ENVIRONMENT, versionNameSuffix = "-dev"),
    production(dimension = FlavorDimension.ENVIRONMENT, versionNameSuffix = "-prod")
}

fun configureFlavors(
    commonExtension: CommonExtension<*, *, *, *, *>,
    flavorConfigurationBlock: ProductFlavor.(flavor: AppFlavor) -> Unit = {}
) {
    commonExtension.apply {
        FlavorDimension.values().forEach { mDimension ->
            flavorDimensions.add(mDimension.name)
        }
        productFlavors {
            AppFlavor.values().forEach { mFlavor ->
                create(mFlavor.name) {
                    dimension = mFlavor.dimension.name
                    if (mFlavor.dimension == FlavorDimension.DEVICE) {
                        when(name) {
                            AppFlavor.tv.name -> {
                                manifestPlaceholders["launcherCategory"] = "LEANBACK_LAUNCHER"
                            }
                            AppFlavor.mobile.name -> {
                                manifestPlaceholders["launcherCategory"] = "LAUNCHER"
                            }
                        }
                    }
                    if (this@apply is ApplicationExtension && this is ApplicationProductFlavor) {
                        mFlavor.applicationIdSuffix?.let {
                            applicationIdSuffix = it
                        }
                        mFlavor.versionNameSuffix?.let {
                            versionNameSuffix = it
                        }
                    }
                }
            }
        }
    }
}