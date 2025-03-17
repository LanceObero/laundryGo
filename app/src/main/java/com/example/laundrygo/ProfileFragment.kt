package com.example.laundrygo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile2, container, false)

        val receiptTextView: TextView = view.findViewById(R.id.receiptTextView)

        // ✅ Get order details from SharedPreferences
        val orderDetails = getLatestOrderDetails()

        // ✅ Display order details (center text if no details)
        if (orderDetails == "No order found") {
            receiptTextView.text = orderDetails
            receiptTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER
        } else {
            receiptTextView.text = orderDetails
        }

        return view
    }

    // ✅ Retrieve order details from SharedPreferences
    private fun getLatestOrderDetails(): String {
        val sharedPreferences = requireActivity().getSharedPreferences("LaundryGoPrefs", Context.MODE_PRIVATE)
        return sharedPreferences.getString("LATEST_ORDER", "No order found") ?: "No order found"
    }
}
