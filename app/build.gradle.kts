plugins {
    id("android-app-convention")
    id("my-plugin")
    id("telegram-reporter")
}

myPlugin {
    myDeps {
        enable.set(true)
        prefix.set("PPPPP")
    }
}

tgReporter {
    token.set(providers.environmentVariable("TG_TOKEN"))
    chatId.set(providers.environmentVariable("TG_CHAT"))
}

android {
    defaultConfig {
        applicationId = "ru.yandex.shmr24"
        versionCode = 1
        versionName = "1.0"
    }
    flavorDimensions += "plan"
    productFlavors {
        create("paid") {
            dimension = "plan"
            buildConfigField("boolean", "PAID",  "true")
        }
        create("free") {
            dimension = "plan"
            buildConfigField("boolean", "PAID",  "false")
        }
    }
}

dependencies {

    implementation(projects.feature1)
    implementation(projects.feature2)

    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)
    testImplementation(libs.junit)
}