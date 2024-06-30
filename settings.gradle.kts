rootProject.name = "Shmr24"

include(":app")
include(":core")
include(":core2")
include(":model")
include(":model2")
include(":feature1")
include(":feature2")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}


