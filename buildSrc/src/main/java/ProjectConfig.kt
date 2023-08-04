
object ProjectConfig {
    const val hiltClasspath = "com.google.dagger:hilt-android-gradle-plugin:2.46.1"

    object Plugins {
        const val androidApplication = "com.android.application"
        const val kotlinAndroid = "org.jetbrains.kotlin.android"
        const val daggerHilt = "com.google.dagger.hilt.android"
        const val androidLibrary = "com.android.library"

        object Versions {
            const val androidApplication = "8.0.1"
            const val kotlinAndroid = "1.7.20"
            const val daggerHilt = "2.44"
            const val androidLibrary = "8.0.1"
        }
    }
}