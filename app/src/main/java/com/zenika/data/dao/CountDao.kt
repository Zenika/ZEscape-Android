package com.zenika.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.zenika.data.model.CountDto
import kotlinx.coroutines.flow.Flow

@Dao
interface CountDao {

    @Upsert(CountDto::class)
    suspend fun upsert(count: CountDto)

    @Query("SELECT * FROM CountDto LIMIT 1")
    fun observeCount(): Flow<CountDto?>

    @Query("SELECT * FROM CountDto LIMIT 1")
    suspend fun getCount(): CountDto?

}
