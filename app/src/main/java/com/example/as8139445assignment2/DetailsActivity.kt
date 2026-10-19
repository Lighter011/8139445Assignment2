package com.example.as8139445assignment2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.JsonParser

// Displays all information about the selected entity
class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Connect UI components
        val detailsText = findViewById<TextView>(
            R.id.tvEntityDetails
        )

        val backButton = findViewById<Button>(
            R.id.btnBack
        )

        // Receive entity information from Dashboard
        val entityJson = intent.getStringExtra("entity")

        if (!entityJson.isNullOrEmpty()) {
            try {
                val entity = JsonParser.parseString(
                ).asJsonObject

                // Format text, numbers, and lists
                val details = entity.entrySet()
                    .joinToString("\n\n") { entry ->

                        val value = when {
                            entry.value.isJsonArray -> {
                                entry.value.asJsonArray
                                    .joinToString(", ") {
                                        it.asString
                                    }
                            }

                            entry.value.isJsonNull -> {
                                "Not available"
                            }

                            entry.value.isJsonPrimitive -> {
                                entry.value.asString
                            }

                            else -> entry.value.toString()
                        }

                        "${entry.key}: $value"
                    }

                // Display all information including description
                detailsText.text = details

            } catch (e: Exception) {
                detailsText.text =
                    "Unable to display entity details"
            }

        } else {
            detailsText.text = "No entity information received"
        }

        // Return to Dashboard
        backButton.setOnClickListener {
            finish()
        }
    }
}
