
package com.example.as8139445assignment2

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

// Starts Koin when the application launches
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialise dependency injection
        startKoin {

            // Provide Android application context
            androidContext(this@MyApplication)

            // Load our Koin dependency module
            modules(appModule)
        }
    }
}
