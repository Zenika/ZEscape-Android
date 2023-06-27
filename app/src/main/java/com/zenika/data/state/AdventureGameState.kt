package com.zenika.data.state

import com.zenika.data.Agency

data class AdventureGameState(
    val agencies: Set<Agency> = setOf(),
    val collectSingaporeKey: Boolean = false,
    val collectSword: Boolean = false,
    val collectHook: Boolean = false,
    val penaltyCount: Int = 0,
    val hintCount: Int = 0,
    val newItem: Boolean = false
)
