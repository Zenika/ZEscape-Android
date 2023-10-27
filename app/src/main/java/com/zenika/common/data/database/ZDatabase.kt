package com.zenika.common.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zenika.common.data.entity.ItemEntity

@Database(
    entities = [ItemEntity::class],
    version = 1,
    autoMigrations = []
)
abstract class ZDatabase : RoomDatabase() {
    abstract val itemDao: ItemDao
}
