// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    // Room Зависимость
    id("com.google.devtools.ksp") version "2.0.0-1.0.21" apply false
    //SafeArgs
    id("androidx.navigation.safeargs.kotlin") version "2.5.3" apply false
}