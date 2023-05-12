package com.zenika.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemDto(
    @PrimaryKey(autoGenerate = false)
    val name: String,
    @ColumnInfo("resource")
    val resource: Int
)
