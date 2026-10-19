
package com.example.as8139445assignment2

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import org.koin.androidx.viewmodel.dsl.viewModel


// Koin provides the objects needed for API communication
val appModule = module {

    // Create one Retrofit instance
    single {
        Retrofit.Builder()
            .baseUrl("https://nit3213apinew.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Create ApiService using the Retrofit instance
    single<ApiService> {
        get<Retrofit>().create(ApiService::class.java)
    }
    // Provide EntityRepository with ApiService
    single {
        EntityRepository(get())
    }

    // Provide ViewModels using Koin
    viewModel { LoginViewModel(get()) }

    viewModel { DashboardViewModel(get()) }

    viewModel { DetailsViewModel() }

}
