@file:Suppress("UnstableApiUsage")

plugins {
    id(PluginConfig.androidApplication)
    id(PluginConfig.kotlinAndroid)
    id(PluginConfig.kotlinKapt)
    id(PluginConfig.daggerHilt)
}

android {
    namespace = AppConfig.namespace
    compileSdk = AppConfig.compileSDK
    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSDK
        targetSdk = AppConfig.targetSDK
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.testRunner
        vectorDrawables.useSupportLibrary = AppConfig.canUseVectorDrawables
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildTypes {
        release {
            isMinifyEnabled = AppConfig.canMinify
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = AppConfig.JVMTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AppConfig.kotlinCompilerExtension
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    implementation(CoreDependencies.core)
    implementation(UIDependencies.lifecycleRunTime)
    implementation(UIDependencies.composeActivity)
    implementation(platform(UIDependencies.composeBom))
    implementation(UIDependencies.composeUI)
    implementation(UIDependencies.composeGraphics)
    implementation(UIDependencies.composeToolingPreview)
    implementation(UIDependencies.composeMaterial3)
    implementation(UIDependencies.material)
    implementation(UIDependencies.animatedBottomBar)

    implementation(UIDependencies.lifecycleViewModel)
    implementation(UIDependencies.lifecycleViewModelCompose)
    implementation(UIDependencies.lifecycleLiveData)
    implementation(UIDependencies.lifecycleComposeUtils)
    implementation(UIDependencies.savedStateHandle)
    kapt(UIDependencies.lifecycleCompiler)
    implementation(DIDependencies.daggerHilt)
    kapt(DIDependencies.hiltCompiler)
    implementation(NetworkDependencies.retrofit)
    implementation(NetworkDependencies.gson)
    implementation(UIDependencies.coil)
    implementation(UIDependencies.hiltNavigationCompose)
    implementation(UIDependencies.navigationCompose)
    implementation(UIDependencies.coilCompose)
    implementation(CoreDependencies.sharedPref)

    testImplementation(TestDependencies.jUnit)
    androidTestImplementation(TestDependencies.jUnitExtension)
    androidTestImplementation(TestDependencies.espressoCore)
    androidTestImplementation(platform(TestDependencies.composeBom))
    androidTestImplementation(TestDependencies.jUnitCompose)

    debugImplementation(DebugDependecies.composeUiTooling)
    debugImplementation(DebugDependecies.composeUiManifest)

}