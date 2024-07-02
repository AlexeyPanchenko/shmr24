plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    baseAndroidLibConfig()
}

dependencies {
    api(libs.retrofit)
    api(libs.retrofit.converter.gson)
    api(libs.gson)
}
