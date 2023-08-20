
object ProjectConfig {
    const val hiltClasspath = "com.google.dagger:hilt-android-gradle-plugin:2.46.1"
    const val serialization = "org.jetbrains.kotlin:kotlin-serialization:1.8.21"

    object Plugins {
        const val androidApplication = "com.android.application"
        const val kotlinAndroid = "org.jetbrains.kotlin.android"
        const val daggerHilt = "com.google.dagger.hilt.android"
        const val androidLibrary = "com.android.library"

        object Versions {
            const val androidApplication = "7.3.0"
            const val kotlinAndroid = "1.8.21"
            const val daggerHilt = "2.44"
            const val androidLibrary = "7.3.0"
        }
    }
}