package com.example.laundrygo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SoapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soap)

        // Map detergent options to their respective IDs
        val soapOptions = mapOf(
            R.id.linearLayout2 to "Tide",
            R.id.linearLayout3 to "Breeze",
            R.id.linearLayout4 to "Surf",
            R.id.linearLayout to "Ariel"
        )

        // Set click listeners dynamically
        soapOptions.forEach { (layoutId, soapName) ->
            findViewById<View>(layoutId).setOnClickListener {
                navigateToFabricConditioner(soapName)
            }
        }

        // Back button functionality
        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun navigateToFabricConditioner(selectedSoap: String) {
        val intent = Intent(this, FabricConditionerActivity::class.java).apply {
            putExtra("selectedSoap", selectedSoap) // Pass selected detergent
        }
        startActivity(intent)
    }
}
