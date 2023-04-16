package com.zenika.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CountDto(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo("value")
    val value: Int
)
