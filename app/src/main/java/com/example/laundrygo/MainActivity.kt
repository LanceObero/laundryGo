package com.example.laundrygo

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var textViewSignIn: TextView
    private lateinit var requestQueue: RequestQueue
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        textViewSignIn = findViewById(R.id.textViewSignIn)

        // Initialize Volley request queue and ProgressDialog
        requestQueue = Volley.newRequestQueue(this)
        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Logging in...")

        // Navigate to SignupActivity when clicking on textViewSignIn
        textViewSignIn.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        // Handle login button click
        buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            if (validateInput(email, password)) {
                loginUser(email, password)
            }
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        return when {
            email.isEmpty() || password.isEmpty() -> {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                false
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show()
                false
            }
            password.length < 6 -> {
                Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show()
                false
            }
            else -> true
        }
    }

    private fun loginUser(email: String, password: String) {
        progressDialog.show()

        val url = "http://10.0.2.2/laundrygo/login.php"

        val request = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener { response ->
                progressDialog.dismiss()
                handleLoginResponse(response)
            },
            Response.ErrorListener { error ->
                progressDialog.dismiss()
                Toast.makeText(this, "Login failed: ${error.message}", Toast.LENGTH_SHORT).show()
            }) {

            override fun getParams(): Map<String, String> {
                return mapOf("email" to email, "password" to password)
            }
        }

        requestQueue.add(request)
    }

    private fun handleLoginResponse(response: String) {
        try {
            val jsonResponse = JSONObject(response)
            val status = jsonResponse.getString("status")
            val message = jsonResponse.getString("message")

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            if (status == "success") {
                val intent = Intent(this, home::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Error parsing response", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }
}
