package com.zenika.data.state

import com.zenika.data.TutorialHint

data class TutorialGameState(
    val chestOpened: Boolean = false,
    val keyCollected: Boolean = false,
    val mapCollected: Boolean = false,
    val penaltyCount: Int = 0,
    val hintCount: Int = 0,
    val newItem: Boolean = false,
    val currentHint: TutorialHint = TutorialHint.CAPTAIN_CHEST
)
