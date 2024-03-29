package com.zenika.story.tutorial.presentation.item

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.R
import com.zenika.story.tutorial.domain.ApplyPenaltyUseCase
import com.zenika.story.tutorial.domain.FinishGameUseCase
import com.zenika.story.tutorial.domain.RemoveKeyFromInventoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TutorialItemViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val removeKeyFromInventory: RemoveKeyFromInventoryUseCase,
    private val finishGameUseCase: FinishGameUseCase,
    private val applyPenaltyUseCase: ApplyPenaltyUseCase
) : ViewModel() {
    private var itemId: Int =
        savedStateHandle.get<Int>("item") ?: error("Item is required")

    private var _item = MutableStateFlow(itemId)
    val item: StateFlow<Int?> = _item
        .onEach {
            when (it) {
                R.mipmap.rolled_map -> {
                    finishGame()
                }

                R.mipmap.key -> {
                    applyPenalty()
                }
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = null
        )

    private fun applyPenalty() {
        deleteKey()
        applyPenaltyUseCase()
    }

    private fun finishGame() {
        finishGameUseCase()
    }

    private fun deleteKey() {
        viewModelScope.launch {
            removeKeyFromInventory()
        }
    }
}
