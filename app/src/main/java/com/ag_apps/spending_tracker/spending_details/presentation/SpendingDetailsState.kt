package com.ag_apps.spending_tracker.spending_details.presentation


data class SpendingDetailsState(
    val name: String = "",
    val price: Double = 0.0,
    val isPlastic: Boolean = false,
    val quantity: Double = 0.0,
)
