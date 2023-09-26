plugins {
    id("jarvis.android.feature")
}

android {
    namespace = "com.iot.feature.home"
}

dependencies {
    implementation(libs.kotlinx.coroutines)
}