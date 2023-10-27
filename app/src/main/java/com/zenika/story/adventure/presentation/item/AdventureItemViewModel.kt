package com.zenika.story.adventure.presentation.item

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class AdventureItemViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var itemRes: Int =
        savedStateHandle.get<Int>("item") ?: error("Item is required")

    private var _item = MutableStateFlow(itemRes)
    val item: StateFlow<Int?> = _item
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = null
        )
}
