package com.zenika.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zenika.data.dao.ItemDao
import com.zenika.data.model.ItemDto

@Database(
    entities = [ItemDto::class],
    version = 1,
    autoMigrations = []
)
abstract class ZDatabase : RoomDatabase() {
    abstract val itemDao: ItemDao
}
