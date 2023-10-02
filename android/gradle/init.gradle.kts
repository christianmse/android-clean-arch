val ktlintVersion = "0.48.1"

initscript {
    plugins {
        id("com.diffplug.gradle.spotless") version "6.22.0"
    }
}

// Apply plugin to all project modules
rootProject {
    ratchetFrom 'origin/master'

    subprojects {
        apply<com.diffplug.gradle.spotless.SpotlessPlugin>()
        extensions.configure<com.diffplug.gradle.spotless.SpotlessExtension> {
            kotlin {
                target("**/*.kt")
                targetExclude("**/build/**/*.kt")
                ktlint(ktlintVersion).userData(mapOf("android" to "true"))
                trimTrailingWhitespace()
                indentWithSpaces()
            }
            format("xml") {
                target("**/*.xml")
                targetExclude("**/build/**/*.xml")
            }
        }
    }
}