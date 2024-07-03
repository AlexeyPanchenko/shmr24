import com.android.build.gradle.internal.tasks.factory.dependsOn
import ru.yandex.shmr24.tasks.GenerateNameTask
import ru.yandex.shmr24.tasks.PrintHelloTask
import ru.yandex.shmr24.tasks.PrintUserNameTask
import ru.yandex.shmr24.tasks.SayHelloUserTask

plugins {
    id("android-app-convention")
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

val printHelloTask = tasks.register("printHello", PrintHelloTask::class)
val printUserNameTask = tasks.register("printUserName", PrintUserNameTask::class)

//printUserNameTask.dependsOn(printHelloTask)
//printUserNameTask.get().shouldRunAfter(printHelloTask)

//val userNameTask = tasks.register("userName", GenerateNameTask::class) {
//    userNameFile.set(File("userName.txt"))
//}
//
//tasks.register("helloUser", SayHelloUserTask::class) {
//    userNameFile.set(userNameTask.get().userNameFile)
//}
