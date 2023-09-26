plugins {
    id("jarvis.android.library")
}

android {
    namespace = "com.iot.core.common"
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    testImplementation(libs.junit4)
    androidTestImplementation(libs.junit)
}