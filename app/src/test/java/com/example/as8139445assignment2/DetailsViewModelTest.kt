
package com.example.as8139445assignment2

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class DetailsViewModelTest {

    @Test
    fun selectedEntityIsStoredCorrectly() {

        val viewModel = DetailsViewModel()

        val entity = """
            {
                "name": "Kotlin",
                "description": "Programming language"
            }
        """.trimIndent()

        viewModel.setEnti
        assertEquals(ty(entity)
entity, viewModel.getEntity())
    }

    @Test
    fun selectedEntityIsInitiallyNull() {

        val viewModel = DetailsViewModel()

        assertNull(viewModel.getEntity())
    }
}
