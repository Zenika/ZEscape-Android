package com.zenika.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.zenika.data.model.ItemDto
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Upsert(ItemDto::class)
    suspend fun upsertItem(item: ItemDto)

    @Query("SELECT * FROM ItemDto")
    fun getItems(): Flow<List<ItemDto>>
}
