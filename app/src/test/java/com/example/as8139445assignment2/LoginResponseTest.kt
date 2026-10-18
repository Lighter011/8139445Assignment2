package com.example.as8139445assignment2

import org.junit.Assert.assertEquals
import org.junit.Test

class LoginResponseTest {

    @Test
    fun loginResponseStoresKeypass() {

        // Create a sample API login response
        val response = LoginResponse(
            keypass = "sample_keypass_123"
        )

        // Check that the keypass is stored correctly
        assertEquals(
            "sample_keypass_123",
            response.keypass
        )
    }
}
