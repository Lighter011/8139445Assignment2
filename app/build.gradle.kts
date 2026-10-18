plugins {
    alias(libs.plugins.android.application)



}

android {
    namespace = "com.example.as8139445assignment2"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.as8139445assignment2"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = true
                packageScope = setOf("androidx.**", "kotlin.**", "kotlinx.**")
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)

    // Retrofit - API communication
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")

    // RecyclerView - Dashboard list
    implementation("androidx.recyclerview:recyclerview:1.3.2")

    // ViewModel and lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")

    // Koin - Dependency Injection
    implementation("io.insert-koin:koin-android:4.1.1")

    // Mock API server for unit testing
    testImplementation("com.squareup.okhttp3:mockwebserver:4.12.0")

    // Run suspend functions in unit tests
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.10.2")


}
