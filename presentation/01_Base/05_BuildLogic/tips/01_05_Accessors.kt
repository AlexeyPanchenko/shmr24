import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware

internal fun Project.android(configure: Action<LibraryExtension>): Unit =
    (this as ExtensionAware).extensions.configure("android", configure)

internal val Project.libs: LibrariesForLibs
    get() = (this as ExtensionAware).extensions.getByName("libs") as LibrariesForLibs

internal fun BaseExtension.kotlinOptions(configure: Action<org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions>): Unit =
    (this as ExtensionAware).extensions.configure("kotlinOptions", configure)
