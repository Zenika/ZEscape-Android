package com.zenika.adventure.presentation.inventory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.ObserveInventoryUseCase
import com.zenika.data.state.InventoryState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class AdventureInventoryViewModel @Inject constructor(
    observeInventory: ObserveInventoryUseCase
) : ViewModel() {

    val inventoryItems: StateFlow<InventoryState> = observeInventory()
        .map { items -> InventoryState(items) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = InventoryState.start()
        )
}
