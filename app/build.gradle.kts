import com.iot.convention.AppBuildType

plugins {
    id("jarvis.android.application")
    id("jarvis.android.flavors")
    id("jarvis.android.koin")
}
val majorVersion = 1
val minorVersion = 0
val patchLevel = 0

android {
    namespace = "com.iot.jarvis"

    defaultConfig {
        applicationId = "com.iot.jarvis"
        versionCode = majorVersion * 100 + minorVersion * 10 + patchLevel
        versionName = "${majorVersion}.${minorVersion}.${patchLevel}"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            applicationIdSuffix = AppBuildType.DEBUG.applicationIdSuffix
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintLayout)
    implementation(libs.androidx.navigation.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.espresso.core)
}