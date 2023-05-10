package com.zenika.tutorial.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InventoryViewModel @Inject constructor() : ViewModel() {

    private var _inventoryItems =
        MutableStateFlow(
            mutableMapOf(
                "paper" to R.mipmap.paper
            )
        )
    val inventoryItems: StateFlow<Map<String, Int>> = _inventoryItems
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = mapOf(
                "paper" to R.mipmap.paper
            )
        )

    fun addItem(item: String, itemId: Int) {
        viewModelScope.launch {
            _inventoryItems.update { items ->
                items[item] = itemId
                items
            }
        }
    }
}