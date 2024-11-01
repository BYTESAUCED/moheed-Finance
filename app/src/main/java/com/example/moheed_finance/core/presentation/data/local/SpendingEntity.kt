package com.example.moheed_finance.core.presentation.domain

import java.time.ZonedDateTime

data class Spending(
    val spendingId: Int?,
    val storeName: String,
    val ItemName: String,
    val ItemPrice: Double,
    val ItemQuantity: Double,
    val dateTimeUtc: ZonedDateTime,
    val color : Int = 0
)