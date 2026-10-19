
package com.example.as8139445assignment2

import androidx.lifecycle.ViewModel

// Handles login requests through the repository
class LoginViewModel(
    private val repository: EntityRepository
) : ViewModel() {

    suspend fun login(
        username: String,
        password: String
    ) = repository.login(username, password)
}
