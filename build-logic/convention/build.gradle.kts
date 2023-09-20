import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.iot.jarvis.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "jarvis.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidFlavors") {
            id = "jarvis.android.flavors"
            implementationClass = "AndroidApplicationFlavorsConventionPlugin"
        }
        register("androidKoin") {
            id = "jarvis.android.koin"
            implementationClass = "AndroidKoinConventionPlugin"
        }
        register("androidLibrary") {
            id = "jarvis.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("jvmLibrary") {
            id = "jarvis.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
        register("kotlinSerializationLibrary") {
            id = "jarvis.kotlin.serialization.library"
            implementationClass = "KotlinSerializationLibraryConventionPlugin"
        }
    }
}