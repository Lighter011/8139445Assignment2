
package com.example.as8139445assignment2

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginViewModelTest {

    @Test
    fun loginReturnsCorrectKeypass() = runTest {

        val server = MockWebServer()
        server.start()

        try {
            server.enqueue(
                MockResponse()
                    .setResponseCode(200)
                    .setBody("""{"keypass":"languages"}""")
            )

            val retrofit = Retrofit.Builder()
                .baseUrl(server.url("/"))
                .addConverterFactory(
                    GsonConverterFactory.create()
                )
                .build()

            val apiService =
                retrofit.create(ApiService::class.java)

            val repository = EntityRepository(apiService)
            val viewModel = LoginViewModel(repository)

            val response = viewModel.login(
                "12345678",
                "Test"
            )

            assertEquals(true, response.isSuccessful)
            assertEquals(
                "languages",
                response.body()?.keypass
            )

        } finally {
            server.shutdown()
        }
    }
}
