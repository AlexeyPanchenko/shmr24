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
    plugins.register("telegram-reporter") {
        id = "telegram-reporter"
        implementationClass = "ru.yandex.shmr24.practice.TelegramReporterPlugin"
    }
}

dependencies {
    implementation(libs.agp)
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.kotlin.coroutines.core)
    implementation(libs.ktor.client)
    implementation(libs.ktor.client.okhttp)
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}