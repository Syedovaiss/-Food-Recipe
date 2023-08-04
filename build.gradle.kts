
// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(ProjectConfig.hiltClasspath)
    }
}
plugins {
    id(ProjectConfig.Plugins.androidApplication) version (ProjectConfig.Plugins.Versions.androidApplication) apply (false)
    id(ProjectConfig.Plugins.androidLibrary) version (ProjectConfig.Plugins.Versions.androidLibrary) apply (false)
    id(ProjectConfig.Plugins.kotlinAndroid) version (ProjectConfig.Plugins.Versions.kotlinAndroid) apply (false)
    id(ProjectConfig.Plugins.daggerHilt) version (ProjectConfig.Plugins.Versions.daggerHilt) apply (false)
}
