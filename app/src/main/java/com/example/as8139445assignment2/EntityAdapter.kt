package com.example.as8139445assignment2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.JsonObject

// Displays language entities as cards in the Dashboard
class EntityAdapter(
    private val entities: List<JsonObject>,
    private val onItemClick: (JsonObject) -> Unit
) : RecyclerView.Adapter<EntityAdapter.EntityViewHolder>() {

    // Holds the views inside each card
    class EntityViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val name: TextView =
            itemView.findViewById(R.id.tvEntityName)

        val summary: TextView =
            itemView.findViewById(R.id.tvEntitySummary)
    }

    // Creates a card using item_entity.xml
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EntityViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_entity, parent, false)

        return EntityViewHolder(view)
    }

    // Displays information for each language
    override fun onBindViewHolder(
        holder: EntityViewHolder,
        position: Int
    ) {
        val entity = entities[position]

        // Get the language name
        val name = entity.get("name")?.asString ?: "Unknown"

        // Get language family and branch
        val family = entity.get("family")?.asString ?: "Unknown"
        val branch = entity.get("branch")?.asString ?: "Unknown"

        // Get the number of speakers
        val speakers = entity.get("speakers")?.asLong ?: 0L

        // Display the language name
        holder.name.text = name

        // Display a short summary without description
        holder.summary.text = """
            Family: $family
            Branch: $branch
            Speakers: ${"%,d".format(speakers)}
        """.trimIndent()

        // Open Details screen when the card is clicked
        holder.itemView.setOnClickListener {
            onItemClick(entity)
        }
    }

    // Returns the number of entities
    override fun getItemCount(): Int = entities.size
}
