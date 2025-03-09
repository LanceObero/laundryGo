package com.example.laundrygo  // Ensure this matches your app package name

import android.os.Bundle
import android.widget.ImageView
import android.widget.TimePicker  // ✅ Add this import to fix the error
import androidx.appcompat.app.AppCompatActivity

class DeliveryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delivery)

        // Initialize and set 24-hour format
        val timePicker = findViewById<TimePicker>(R.id.timePicker)
        timePicker.setIs24HourView(true) // ✅ Fixes the unresolved reference

        // Back button click listener
        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
