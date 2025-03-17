package com.example.laundrygo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OrdersFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var orderAdapter: OrderAdapter
    private val orderViewModel: OrderViewModel by activityViewModels() // ViewModel shared with Activity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_orders2, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewOrders)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Initialize adapter with an empty list
        orderAdapter = OrderAdapter(emptyList())
        recyclerView.adapter = orderAdapter

        // Observe ViewModel for order list updates
        orderViewModel.orderList.observe(viewLifecycleOwner) { orders ->
            orderAdapter.updateOrders(orders) // ✅ Update adapter with the full order list
        }

        return view
    }
}
