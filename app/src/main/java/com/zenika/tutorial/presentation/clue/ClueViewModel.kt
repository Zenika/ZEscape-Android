package com.zenika.tutorial.presentation.clue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.data.state.GameState
import com.zenika.tutorial.domain.GetCurrentClueUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ClueViewModel @Inject constructor(
    getCurrentClueUseCase: GetCurrentClueUseCase,
    gameState: GameState
) : ViewModel() {
    val currentClue = getCurrentClueUseCase()
        .map { clue -> gameState.clues[clue] }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = 0
        )
}