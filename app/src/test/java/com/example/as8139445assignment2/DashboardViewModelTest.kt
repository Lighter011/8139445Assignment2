
package com.example.as8139445assignment2

import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DashboardViewModelTest {

    @Test
    fun dashboardReturnsEntities() = runTest {

        val server = MockWebServer()
        server.start()

        try {
            server.enqueue(
                MockResponse()
                    .setResponseCode(200)
                    .setBody(
                        """
                        {
                            "entities": [
                                {
                                    "name": "Kotlin",
                                    "description": "Programming language"
                                }
                            ],
                            "entityTotal": 1
                        }
                        """.trimIndent()
                    )
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
            val viewModel = DashboardViewModel(repository)

            val response = viewModel.getDashboard("languages")

            assertTrue(response.isSuccessful)
            assertEquals(1, response.body()?.entities?.size)
            assertEquals(1, response.body()?.entityTotal)

            val request = server.takeRequest()
            assertEquals("GET", request.method)
            assertEquals("/dashboard/languages", request.path)

        } finally {
            server.shutdown()
        }
    }
}
