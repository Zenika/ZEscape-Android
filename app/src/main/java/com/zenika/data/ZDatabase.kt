package com.zenika.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zenika.data.dao.CountDao
import com.zenika.data.model.CountDto

@Database(
    entities = [CountDto::class],
    version = 1,
    autoMigrations = []
)
abstract class ZDatabase : RoomDatabase() {
    abstract val countDao: CountDao
}
