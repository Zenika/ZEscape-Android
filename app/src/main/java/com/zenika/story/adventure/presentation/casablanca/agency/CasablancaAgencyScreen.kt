package com.zenika.story.adventure.presentation.casablanca.agency

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.common.component.HintButton
import com.zenika.story.adventure.domain.model.AdventureHint
import com.zenika.story.adventure.presentation.casablanca.component.CasablancaMap
import com.zenika.story.adventure.presentation.casablanca.component.FlashlightScaffoldScreen
import com.zenika.story.adventure.presentation.casablanca.component.Safe
import com.zenika.theme.ScreenPreview
import com.zenika.theme.ZEscapeThemePreview

@Composable
fun CasablancaAgencyScreen(
    remainingTime: Int,
    newItem: Boolean,
    isSafeOpened: Boolean,
    isKeyCollected: Boolean,
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    openAgencyMap: () -> Unit,
    openHintValidation: (AdventureHint) -> Unit,
    goToSafe: () -> Unit,
    collectKey: () -> Unit,
    modifier: Modifier = Modifier
) {
    FlashlightScaffoldScreen(
        modifier = modifier,
        newItem = newItem,
        remainingTime = remainingTime,
        goToSettings = goToSettings,
        background = R.mipmap.casablanca_agency,
        openWorldMap = openWorldMap,
        openInventory = openInventory,
        navigationIcon = { HintButton(onClick = { openHintValidation(AdventureHint.CASABLANCA_FLASHLIGHT_HINT) }) }
    ) {
        CasablancaMap(
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.TopCenter)
                .padding(top = 100.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = openAgencyMap
                )
        )
        Safe(
            isSafeOpened,
            isKeyCollected,
            goToSafe,
            collectKey,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@ScreenPreview
@Composable
private fun CasablancaAgencyScreenPreview() {
    ZEscapeThemePreview {
        CasablancaAgencyScreen(
            remainingTime = 3_600,
            newItem = false,
            isSafeOpened = false,
            isKeyCollected = false,
            goToSettings = {},
            openWorldMap = {},
            openInventory = {},
            openAgencyMap = {},
            openHintValidation = {},
            goToSafe = {},
            collectKey = {}
        )
    }
}
