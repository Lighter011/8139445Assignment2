
package com.example.as8139445assignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    // Koin provides the API service automatically
    private val repository: EntityRepository by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get login fields and button
        val username = findViewById<EditText>(R.id.etUsername)
        val password = findViewById<EditText>(R.id.etPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)

        // Handle login button click
        loginButton.setOnClickListener {

            val user = username.text.toString().trim()
            val pass = password.text.toString()

            // Check if fields are empty
            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(
                    this,
                    "Please enter username and password",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // Send login request to API
            lifecycleScope.launch {
                loginButton.isEnabled = false

                try {
                    val response = repository.login(user, pass)


                    if (response.isSuccessful &&
                        response.body() != null) {

                        // Save keypass for Dashboard
                        val keypass = response.body()!!.keypass

                        Toast.makeText(
                            this@MainActivity,
                            "Login successful",
                            Toast.LENGTH_SHORT
                        ).show()

                        // Open Dashboard screen
                        val intent = Intent(
                            this@MainActivity,
                            DashboardActivity::class.java
                        )
                        intent.putExtra("keypass", keypass)
                        startActivity(intent)

                    } else {
                        Toast.makeText(
                            this@MainActivity,
                            "Invalid username or password",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                } catch (e: Exception) {
                    Toast.makeText(
                        this@MainActivity,
                        "Network error. Please try again.",
                        Toast.LENGTH_SHORT
                    ).show()
                } finally {
                    loginButton.isEnabled = true
                }
            }
        }
    }
}
