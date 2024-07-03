import org.gradle.api.JavaVersion

object `01_05_AndroidConst` {

    const val NAMESPACE = "ru.yandex.shmr24"
    const val COMPILE_SKD = 34
    const val MIN_SKD = 24
    val COMPILE_JDK_VERSION = JavaVersion.VERSION_1_8
    const val KOTLIN_JVM_TARGET = "1.8"
}