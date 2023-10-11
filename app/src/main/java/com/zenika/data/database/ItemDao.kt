package com.zenika.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.zenika.data.entity.ItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Upsert(ItemEntity::class)
    suspend fun upsertItem(item: ItemEntity)

    @Delete(ItemEntity::class)
    suspend fun deleteItem(item: ItemEntity)

    @Query("SELECT * FROM ItemEntity")
    fun observeItems(): Flow<List<ItemEntity>>

    @Query("DELETE FROM ItemEntity")
    suspend fun deleteAll()
}
