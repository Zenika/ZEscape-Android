package com.zenika.story.tutorial.presentation.inventory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.common.domain.Inventory
import com.zenika.common.domain.ObserveInventoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class TutorialInventoryViewModel @Inject constructor(
    observeInventory: ObserveInventoryUseCase
) : ViewModel() {
    val inventory: StateFlow<Inventory> = observeInventory()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = Inventory.start()
        )
}
