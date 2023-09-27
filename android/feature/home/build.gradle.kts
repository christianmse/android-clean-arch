plugins {
    id("jarvis.android.feature")
    id("jarvis.android.koin")
}

android {
    namespace = "com.iot.feature.home"
}

dependencies {
    implementation(libs.kotlinx.coroutines)
}