package com.example.laundrygo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SoapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soap)

        // Set click listeners for detergent options
        findViewById<View>(R.id.linearLayout2).setOnClickListener {
            navigateToFabricConditioner("Tide")
        }

        findViewById<View>(R.id.linearLayout3).setOnClickListener {
            navigateToFabricConditioner("Breeze")
        }

        findViewById<View>(R.id.linearLayout4).setOnClickListener {
            navigateToFabricConditioner("Surf")
        }

        findViewById<View>(R.id.linearLayout).setOnClickListener {
            navigateToFabricConditioner("Ariel")
        }
    }

    private fun navigateToFabricConditioner(selectedSoap: String) {
        val intent = Intent(this, FabricConditionerActivity::class.java)
        intent.putExtra("selectedSoap", selectedSoap) // Pass selected detergent
        startActivity(intent)
    }
}
