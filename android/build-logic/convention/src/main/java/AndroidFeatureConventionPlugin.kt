import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("jarvis.android.library")
                apply("jarvis.android.koin")
            }
            dependencies {
                add("implementation", project(":core:model"))
                add("implementation", project(":core:domain"))
            }
        }
    }
}