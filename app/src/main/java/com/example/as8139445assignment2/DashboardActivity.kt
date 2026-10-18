package com.example.as8139445assignment2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

// Displays entities retrieved from the dashboard API
class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Connect UI components
        val recyclerView = findViewById<RecyclerView>(
            R.id.recyclerViewEntities
        )
        val statusText = findViewById<TextView>(R.id.tvStatus)

        // Display entities in a vertical list
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Receive keypass from Login screen
        val keypass = intent.getStringExtra("keypass")

        if (keypass.isNullOrEmpty()) {
            Toast.makeText(
                this,
                "Missing login information",
                Toast.LENGTH_SHORT
            ).show()
            finish()
            return
        }

        // Retrieve dashboard entities from API
        lifecycleScope.launch {
            statusText.text = "Loading dashboard..."

            try {
                val response = RetrofitClient.apiService
                    .getDashboard(keypass)

                if (response.isSuccessful) {
                    val entities = response.body()?.entities.orEmpty()

                    if (entities.isEmpty()) {
                        statusText.text = "No entities found"
                    } else {
                        statusText.visibility = View.GONE

                        // Show entities using RecyclerView
                        recyclerView.adapter = EntityAdapter(entities) { entity ->

                            // Open Details screen when item is clicked
                            val intent = Intent(
                                this@DashboardActivity,
                                DetailsActivity::class.java
                            )

                            intent.putExtra("entity", entity.toString())
                            startActivity(intent)
                        }
                    }
                } else {
                    statusText.text = "Failed to load dashboard"
                }

            } catch (e: Exception) {
                statusText.text = "Network error. Please try again."
            }
        }
    }
}
