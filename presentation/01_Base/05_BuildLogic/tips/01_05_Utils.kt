import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension

fun BaseExtension.baseAndroidConfig() {
    namespace = AndroidConst.NAMESPACE
    defaultConfig {
        minSdk = AndroidConst.MIN_SKD
    }

    compileOptions {
        sourceCompatibility = AndroidConst.COMPILE_JDK_VERSION
        targetCompatibility = AndroidConst.COMPILE_JDK_VERSION
    }
    kotlinOptions {
        jvmTarget = AndroidConst.KOTLIN_JVM_TARGET
    }
}

fun LibraryExtension.baseAndroidLibConfig() {
    baseAndroidConfig()
    compileSdk = AndroidConst.COMPILE_SKD
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

