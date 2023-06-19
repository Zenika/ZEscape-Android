package com.zenika.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.zenika.data.model.ItemDto
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Upsert(ItemDto::class)
    suspend fun upsertItem(item: ItemDto)

    @Delete(ItemDto::class)
    suspend fun deleteItem(item: ItemDto)

    @Query("SELECT * FROM ItemDto")
    fun observeItems(): Flow<List<ItemDto>>

    @Query("DELETE FROM ItemDto")
    suspend fun deleteAll()
}
