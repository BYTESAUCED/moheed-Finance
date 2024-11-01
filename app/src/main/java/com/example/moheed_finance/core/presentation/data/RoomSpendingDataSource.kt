package com.example.moheed_finance.core.presentation.data.local

import com.example.moheed_finance.core.presentation.domain.LocalSpendingDataSource
import com.example.moheed_finance.core.presentation.domain.Spending
import java.time.ZonedDateTime

class RoomSpendingDataSource(
    private val dao: SpendingDao
): LocalSpendingDataSource {
    override suspend fun getAllSpendings(): List<Spending> {
        TODO("Not yet implemented")
    }

    override suspend fun getSpendingsByDate(dateTimeUtc: ZonedDateTime): List<Spending> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllDates(): List<ZonedDateTime> {
        TODO("Not yet implemented")
    }

    override suspend fun getSpending(id: Int): Spending {
        TODO("Not yet implemented")
    }

    override suspend fun upsertSpending(spending: Spending) {
        TODO("Not yet implemented")
    }

    override suspend fun getSpendBalance(): Double {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSpending(id: Int) {
        TODO("Not yet implemented")
    }
}