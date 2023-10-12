package com.zenika.story.tutorial.data

import com.zenika.story.tutorial.domain.model.TutorialHint

data class TutorialGameState(
    val isChestOpened: Boolean = false,
    val isKeyCollected: Boolean = false,
    val isMapCollected: Boolean = false,
    val penaltyCount: Int = 0,
    val hintCount: Int = 0,
    val newItem: Boolean = false,
    val currentHint: TutorialHint = TutorialHint.CAPTAIN_CHEST
)
