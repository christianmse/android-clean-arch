plugins {
    id("jarvis.android.library")
    id("jarvis.kotlin.serialization.library")
    id("jarvis.android.koin")
    alias(libs.plugins.secrets)
}

android {
    namespace = "com.iot.core.network"
    buildFeatures {
        buildConfig = true
    }
}

secrets {
    propertiesFileName = "secrets.properties"
    defaultPropertiesFileName = "secrets.defaults.properties"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:common"))
    implementation(libs.kotlinx.coroutines)
    implementation(libs.retrofit)
    implementation(libs.retrofit.kotlin.serialization.converter)
    implementation(libs.http.logging.interceptor)
    testImplementation(libs.junit4)
    androidTestImplementation(libs.junit)
}