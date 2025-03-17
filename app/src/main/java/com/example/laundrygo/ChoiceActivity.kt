package com.example.laundrygo


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ChoiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)

        val totalPrice = intent.getIntExtra("TOTAL_COST", 0) // Default to 0 if missing


        val buttonDelivery = findViewById<Button>(R.id.buttonLogin2)
        val buttonPickup = findViewById<Button>(R.id.buttonLogin)

        buttonPickup.setOnClickListener {
            val intent = Intent(this, pickupActivity::class.java) // Fixed
            intent.putExtra("TOTAL_COST", totalPrice) // Pass the total cost
            startActivity(intent)
        }

        buttonDelivery.setOnClickListener {
            val intent = Intent(this, DeliveryActivity::class.java)
            intent.putExtra("TOTAL_COST", totalPrice) // Pass the total cost
            startActivity(intent)

        }

        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
