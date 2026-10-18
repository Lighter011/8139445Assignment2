
package com.example.as8139445assignment2

import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EntityRepositoryTest {

    private lateinit var server: MockWebServer
    private lateinit var repository: EntityRepository

    @Before
    fun setUp() {
        // Start a fake API server
        server = MockWebServer()
        server.start()

        // Connect Retrofit to the fake server
        val retrofit = Retrofit.Builder()
            .baseUrl(server.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        // Create repository using the fake API service
        repository = EntityRepository(apiService)
    }

    @After
    fun tearDown() {
        // Stop the fake server after each test
        server.shutdown()
    }

    @Test
    fun loginReturnsKeypass() = runTest {

        // Prepare a successful fake login response
        server.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody("""{"keypass":"test_key_123"}""")
        )

        // Call the repository login function
        val response = repository.login("testuser", "testpassword")

        // Verify the API response
        assertTrue(response.isSuccessful)
        assertEquals("test_key_123", response.body()?.keypass)

        // Verify that the correct API endpoint was called
        val request = server.takeRequest()
        assertEquals("/sydney/auth", request.path)
        assertEquals("POST", request.method)
    }
}
