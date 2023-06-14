package com.zenika.data

import androidx.annotation.StringRes
import com.zenika.R

enum class TutorialHint(
    @StringRes
    val text: Int
) {
    CAPTAIN_CHEST(R.string.captain_chest_hint),
    END_GAME(R.string.end_game_hint),
    NO_HINT(R.string.no_hint),
}