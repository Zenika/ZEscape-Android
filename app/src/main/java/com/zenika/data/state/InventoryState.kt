package com.zenika.data.state

import com.zenika.data.entity.ItemEntity

class InventoryState(
    val items: List<ItemEntity>
) {
    companion object {
        fun start(): InventoryState = InventoryState(
            listOf()
        )
    }
}
