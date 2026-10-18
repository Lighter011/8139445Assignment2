// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    // Hilt dependency injection plugin
    id("com.google.dagger.hilt.android") version "2.57.2" apply false
}