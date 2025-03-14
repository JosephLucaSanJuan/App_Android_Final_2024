// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
    id("androidx.room") version "2.6.1" apply false
    //id("com.android.application") version "8.7.0" apply false
    id("com.android.library") version "8.8.0" apply false
    //id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}
buildscript {
    repositories {
        google()
    }
    dependencies {
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.8.4")
    }
}