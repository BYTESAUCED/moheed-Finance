package com.ag_apps.spending_tracker.spending_details.presentation

//
sealed interface SpendingDetailsAction {

    data class UpdateName(val newName: String): SpendingDetailsAction
    data class UpdatePrice(val newPrice: Double): SpendingDetailsAction
    data class UpdateIsPlastic(var newIsPlastic: Boolean): SpendingDetailsAction
    data class UpdateQuantity(val newQuantity: Double): SpendingDetailsAction

    data object SaveSpending: SpendingDetailsAction

}