package com.zenika.data.state

import com.zenika.data.model.ItemDto

class InventoryState(
    val items: List<ItemDto>
) {
    companion object {
        fun start(): InventoryState = InventoryState(
            listOf()
        )
    }
}