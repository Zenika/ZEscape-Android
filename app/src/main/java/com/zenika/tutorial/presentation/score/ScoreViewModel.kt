package com.zenika.tutorial.presentation.score

import androidx.lifecycle.ViewModel
import com.zenika.data.state.GameState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScoreViewModel @Inject constructor(
    gameState: GameState
) : ViewModel() {
    val penalty = gameState.penaltyCount
    val clue = gameState.clueCount
    val finalTimer = gameState.finalTimer
}
