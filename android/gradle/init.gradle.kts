val ktlintVersion = "0.48.1"

initscript {
    val spotlessVersion = "6.22.0"
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("com.diffplug.spotless:spotless-plugin-gradle:$spotlessVersion")
    }
}

// Apply plugin to all project modules
rootProject {
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