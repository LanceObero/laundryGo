package com.example.laundrygo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {
    private val _orderList = MutableLiveData<List<OrderDetails>>(emptyList()) // Stores multiple orders
    val orderList: LiveData<List<OrderDetails>> get() = _orderList

    fun addOrder(order: OrderDetails) {
        val currentOrders = _orderList.value.orEmpty().toMutableList()
        currentOrders.add(order)
        _orderList.value = currentOrders
    }
}
