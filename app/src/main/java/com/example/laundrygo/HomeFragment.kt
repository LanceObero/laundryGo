package com.example.laundrygo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Wash Button - Navigates to SoapActivity
        val washButton: LinearLayout = view.findViewById(R.id.button1)
        washButton.setOnClickListener {
            navigateToSoapActivity()
        }

        // Handwash Button - Navigates to SoapActivity
        val handwashButton: LinearLayout = view.findViewById(R.id.button3)
        handwashButton.setOnClickListener {
            navigateToSoapActivity()
        }

        val washdryfoldButton: LinearLayout = view.findViewById(R.id.button4)
        washdryfoldButton.setOnClickListener{
            navigateToSoapActivity()
        }

        // Handle click for user icon - Navigates to UserFragment
        val userIcon: ImageView = view.findViewById(R.id.user)
        userIcon.setOnClickListener {
            replaceFragment(UserFragment())
        }

        return view
    }

    private fun navigateToSoapActivity() {
        val intent = Intent(activity, SoapActivity::class.java)
        startActivity(intent)
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment) // Make sure you have a FrameLayout with this ID in your Activity
        transaction.addToBackStack(null) // Allows back navigation
        transaction.commit()
    }
}
