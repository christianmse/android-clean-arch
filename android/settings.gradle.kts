pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Jarvis"
includeBuild("../core_multiplatform/")
include(":app")
include(":feature")
include(":core:common")
include(":core:data")
include(":core:model")
include(":core:network")
include(":core:domain")
include(":feature:home")
