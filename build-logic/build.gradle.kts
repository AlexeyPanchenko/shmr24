plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

gradlePlugin {
    plugins.register("myPlugin") {
        id = "my-plugin"
        implementationClass = "ru.yandex.shmr24.plugins.MyPlugin"
    }
}

dependencies {
    implementation(libs.agp)
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.kotlin.coroutines.core)
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}