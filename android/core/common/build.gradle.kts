plugins {
    id("jarvis.android.library")
    id("jarvis.android.koin")
}

android {
    namespace = "com.iot.core.common"
    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    testImplementation(libs.junit4)
    androidTestImplementation(libs.junit)
}