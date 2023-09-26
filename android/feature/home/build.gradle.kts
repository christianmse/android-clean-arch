plugins {
    id("jarvis.android.feature")
}

android {
    namespace = "com.iot.feature.home"
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.kotlinx.coroutines)
}