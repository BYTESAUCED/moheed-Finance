package com.ag_apps.spending_tracker.core.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//

@Database(entities = [SpendingEntity::class], version = 1)
abstract class SpendingDatabase : RoomDatabase() {
    abstract fun dao(): SpendingDao  // Use 'fun dao(): SpendingDao' to match your DAO interface.

    companion object {
        @Volatile
        private var INSTANCE: SpendingDatabase? = null

        fun getInstance(context: Context): SpendingDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SpendingDatabase::class.java,
                    "spending_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

//@Database(
//    entities = [SpendingEntity::class],
//    version = 1
//)
//abstract class SpendingDatabase: RoomDatabase() {
//    abstract val dao: SpendingDao
//}