package com.ag_apps.spending_tracker.core.peresentaion.util

//
sealed interface Screen {

    @kotlinx.serialization.Serializable
    data object SpendingOverview: Screen

    @kotlinx.serialization.Serializable
    data class SpendingDetails(val spendingId: Int = -1): Screen

    @kotlinx.serialization.Serializable
    data object Balance: Screen

    @kotlinx.serialization.Serializable
    data object GraphScreenDisplay: Screen

}