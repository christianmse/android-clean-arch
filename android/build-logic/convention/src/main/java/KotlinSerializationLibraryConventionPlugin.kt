import com.iot.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class KotlinSerializationLibraryConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("jarvis.android.library")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }
            dependencies {
                "implementation"(libs.findLibrary("kotlinx.json.serialization").get())
            }
        }
    }
}