plugins {
    id("jarvis.android.library")
    id("jarvis.android.koin")
}

android {
    namespace = "com.iot.core.domain"
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:model"))
    implementation(libs.kotlinx.coroutines)
    testImplementation(libs.junit4)
}