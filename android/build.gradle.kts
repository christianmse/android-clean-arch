import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import io.gitlab.arturbosch.detekt.report.ReportMergeTask

plugins {
    alias(libs.plugins.detekt)
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.secrets) apply false
}

apply(plugin = "io.gitlab.arturbosch.detekt")

buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

val detektAll by tasks.registering(Detekt::class) {
    description = "Runs Detekt static code analysis for all modules"
    basePath = projectDir.absolutePath
    ignoreFailures = false
    parallel = true
    autoCorrect = true
    buildUponDefaultConfig = false
    config = files("$rootDir/config/detekt/detekt.yml")
    baseline = file("$rootDir/config/detekt/baseline.xml")
    setSource(files(projectDir))
    include("**/*.kt")
    include("**/*.kts")
    exclude("**/resources/**")
    exclude("**/build/**")
    exclude("**/tmp/**")
    reports {
        sarif.required = true
    }
}

val detektReportMerge by tasks.registering(ReportMergeTask::class) {
    output = project.layout.buildDirectory.file("reports/detekt/merged/merge.sarif")
}

val detektProjectBaseLine by tasks.registering(DetektCreateBaselineTask::class) {
    description = "Creates Detekt baseline on the whole project."
    parallel = true
    config = files("$rootDir/config/detekt/detekt.yml")
    baseline = file("$rootDir/config/detekt/baseline.xml")
    setSource(files(projectDir))
    include("**/*.kt")
    include("**/*.kts")
    exclude("**/resources/**")
    exclude("**/build/**")
    exclude("**/tmp/**")
    dependsOn(tasks.detektGenerateConfig)
}

tasks {
    val clean by registering(Delete::class) {
        delete(rootProject.buildDir)
        delete("${rootProject.projectDir}/feature/build")
        delete("${rootProject.projectDir}/core/build")
    }

    detektReportMerge {
        input.from(withType<Detekt>().map { it.sarifReportFile })
    }

    withType<Detekt>().configureEach {
        finalizedBy(detektReportMerge)
    }
}

detekt {
    source.setFrom(rootDir)
    buildUponDefaultConfig = false
    config.setFrom(files("$rootDir/config/detekt/detekt.yml"))
    baseline = file("$rootDir/config/detekt/baseline.xml")
}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.1")
}