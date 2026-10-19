
package com.example.as8139445assignment2

import androidx.lifecycle.ViewModel

// Handles dashboard data from the repository
class DashboardViewModel(
    private val repository: EntityRepository
) : ViewModel() {

    suspend fun getDashboard(keypass: String) =
        repository.getDashboard(keypass)
}
