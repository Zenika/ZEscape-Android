package com.zenika.data.state

import com.zenika.R
import com.zenika.data.model.ItemDto
import javax.inject.Singleton

@Singleton
class InventoryState(
    val items: List<ItemDto>
) {
    companion object {
        fun start(): InventoryState = InventoryState(
            listOf(
                ItemDto(
                    "parchment",
                    R.mipmap.parchment
                ),
                ItemDto(
                    "paper",
                    R.mipmap.paper
                )
            )
        )
    }
}