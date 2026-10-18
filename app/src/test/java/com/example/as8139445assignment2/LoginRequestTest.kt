package com.example.as8139445assignment2

import org.junit.Assert.assertEquals
import org.junit.Test

class LoginRequestTest {

    @Test
    fun loginRequestStoresUsernameAndPassword() {
        // Create a sample login request
        val request = LoginRequest(
            username = "testuser",
            password = "testpassword"
        )

        // Check that the values are stored correctly
        assertEquals("testuser", request.username)
        assertEquals("testpassword", request.password)
    }
}
