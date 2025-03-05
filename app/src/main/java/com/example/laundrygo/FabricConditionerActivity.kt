package com.example.laundrygo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class FabricConditionerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fabric_conditioner)

        // Set click listeners for fabric conditioner choices
        findViewById<View>(R.id.fabric1).setOnClickListener { navigateToChoiceActivity() }
        findViewById<View>(R.id.fabric2).setOnClickListener { navigateToChoiceActivity() }
        findViewById<View>(R.id.fabric3).setOnClickListener { navigateToChoiceActivity() }
        findViewById<View>(R.id.fabric4).setOnClickListener { navigateToChoiceActivity() }
    }

    private fun navigateToChoiceActivity() {
        val intent = Intent(this, ChoiceActivity::class.java)
        startActivity(intent)
        finish() // Close FabricActivity so the user can't go back
    }
}
