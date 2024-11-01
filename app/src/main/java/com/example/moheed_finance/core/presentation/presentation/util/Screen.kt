package com.example.moheed_finance.core.presentation.presentation

sealed interface Screen {
    @kotlinx.serialization.Serializable
    data object SpendingOveriew:Screen
}