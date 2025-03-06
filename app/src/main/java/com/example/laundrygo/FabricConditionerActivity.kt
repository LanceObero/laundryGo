package com.example.laundrygo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class FabricConditionerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fabric_conditioner)

        // Set up click listeners for fabric choices
        listOf(R.id.fabric1, R.id.fabric2, R.id.fabric3, R.id.fabric4).forEach { id ->
            findViewById<View>(id).setOnClickListener { navigateToChoiceActivity(id) }
        }

        // Back button functionality
        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            onBackPressedDispatcher.onBackPressed() // Uses the system back behavior
        }
    }

    private fun navigateToChoiceActivity(selectedFabricId: Int) {
        val intent = Intent(this, ChoiceActivity::class.java).apply {
            putExtra("FABRIC_SELECTED", selectedFabricId) // Pass selected fabric ID
        }
        startActivity(intent)
    }
}
