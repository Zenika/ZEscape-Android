package com.zenika.data.state

import com.zenika.story.adventure.domain.model.Agency

data class AdventureGameState(
    val agencies: Set<Agency> = setOf(),
    val isSingaporeAgencyOpen: Boolean = false,
    val isSingaporeKeyCollected: Boolean = false,
    val isSwordCollected: Boolean = false,
    val isHookCollected: Boolean = false,
    val isCasablancaAgencyOpen: Boolean = false,
    val isSafeOpen: Boolean = false,
    val isCasablancaKeyCollected: Boolean = false,
    val isCasablancaPaperCollected: Boolean = false,
    val isMontrealAgencyOpen: Boolean = false,
    val isRooftopDiscovered: Boolean = false,
    val isMontrealDoorOpen: Boolean = false,
    val isOfficeDiscovered: Boolean = false,
    val isMontrealKeyCollected: Boolean = false,
    val isMeetingRoomDiscovered: Boolean = false,
    val penaltyCount: Int = 0,
    val hintCount: Int = 0,
    val newItem: Boolean = false
)
