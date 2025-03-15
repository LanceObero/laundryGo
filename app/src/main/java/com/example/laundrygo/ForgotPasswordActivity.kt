package com.example.laundrygo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val resetButton = findViewById<Button>(R.id.buttonResetPassword)

        resetButton.setOnClickListener {
            // Navigate to ChangePasswordActivity
            val intent = Intent(this, ChangePasswordActivity::class.java)
            startActivity(intent)
        }
        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
