package com.example.as8139445assignment2

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

// Stores username and password for login
data class LoginRequest(
    val username: String,
    val password: String
)

// Stores keypass returned after login
data class LoginResponse(
    val keypass: String
)

// Stores the list of dashboard entities
data class DashboardResponse(
    val entities: List<JsonObject>,
    val entityTotal: Int
)

// Defines API endpoints for the app
interface ApiService {

    // Sends login details to Sydney API
    @POST("sydney/auth")
    suspend fun login(
        @Body request: LoginRequest
    ): Response<LoginResponse>

    // Retrieves dashboard data using keypass
    @GET("dashboard/{keypass}")
    suspend fun getDashboard(
        @Path("keypass") keypass: String
    ): Response<DashboardResponse>
}
