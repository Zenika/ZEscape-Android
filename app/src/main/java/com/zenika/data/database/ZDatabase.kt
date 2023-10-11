package com.zenika.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zenika.data.entity.ItemEntity

@Database(
    entities = [ItemEntity::class],
    version = 1,
    autoMigrations = []
)
abstract class ZDatabase : RoomDatabase() {
    abstract val itemDao: ItemDao
}
