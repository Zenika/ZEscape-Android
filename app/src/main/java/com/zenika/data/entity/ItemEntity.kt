package com.zenika.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemEntity(
    @PrimaryKey
    val name: String,
    @ColumnInfo("resource")
    val resource: Int
) {
    companion object {
        val EMPTY = ItemEntity("", 0)
    }
}
