plugins {
    id("jarvis.android.library")
    id("jarvis.android.koin")
}

android {
    namespace = "com.iot.core.local_data"
    buildFeatures {
        buildConfig = true
    }
    defaultConfig {
        buildConfigField("String", "DATA_STORE_FILE_NAME", "\"userPreferences\"")
    }
}

dependencies {
    implementation(libs.androidx.datastore.preferences)
    testImplementation(libs.junit4)
}