plugins {
    id("jarvis.android.library")
    id("jarvis.android.koin")
}

android {
    namespace = "com.iot.core.data"
}

dependencies {
    implementation(project(":core:local-data"))
    implementation(project(":core:model"))
    implementation(project(":core:network"))
    implementation(libs.kotlinx.coroutines)
    testImplementation(libs.junit4)
}