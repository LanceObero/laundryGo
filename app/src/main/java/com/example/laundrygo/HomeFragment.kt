package com.example.laundrygo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val washButton: LinearLayout = view.findViewById(R.id.button1)
        washButton.setOnClickListener {
            val intent = Intent(activity, SoapActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}
