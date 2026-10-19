
package com.example.as8139445assignment2

import androidx.lifecycle.ViewModel

// Stores the selected entity's details
class DetailsViewModel : ViewModel() {

    private var selectedEntity: Any? = null

    fun setEntity(entity: Any) {
        selectedEntity = entity
    }

    fun getEntity(): Any? {
        return selectedEntity
    }
}
