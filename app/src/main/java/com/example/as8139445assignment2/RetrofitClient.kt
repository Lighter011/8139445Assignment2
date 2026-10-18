
package com.example.as8139445assignment2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Connects the app to the API server
object RetrofitClient {

    // Main API URL
    private const val BASE_URL =
        "https://nit3213apinew.onrender.com/"

    // Creates the Retrofit connection
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Provides access to API functions
    val apiService: ApiService =
        retrofit.create(ApiService::class.java)
}
