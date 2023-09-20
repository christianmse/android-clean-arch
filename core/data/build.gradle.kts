plugins {
    id("jarvis.android.library")
}

android {
    namespace = "com.iot.core.data"
}

dependencies {
    implementation(project(":core:model"))
    implementation(libs.kotlinx.coroutines)
    testImplementation(libs.junit4)
}