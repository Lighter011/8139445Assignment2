
package com.example.as8139445assignment2

// Repository handles communication with the API
class EntityRepository(
    private val apiService: ApiService
) {

    // Authenticate the user
    suspend fun login(username: String, password: String) =
        apiService.login(LoginRequest(username, password))

    // Retrieve language entities using the login keypass
    suspend fun getDashboard(keypass: String) =
        apiService.getDashboard(keypass)
}
