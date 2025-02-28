package com.example.laundrygo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SoapActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soap)

        // Set click listeners for detergent buttons
        findViewById<View>(R.id.linearLayout2).setOnClickListener(this) // TIDE
        findViewById<View>(R.id.linearLayout3).setOnClickListener(this) // BREEZE
        findViewById<View>(R.id.linearLayout4).setOnClickListener(this) // SURF
        findViewById<View>(R.id.linearLayout).setOnClickListener(this) // ARIEL
    }

    override fun onClick(view: View?) {
        val intent = Intent(this, FabricConditionerActivity::class.java)
        startActivity(intent)
    }
}
