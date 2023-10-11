package com.zenika.story.adventure.presentation.portal

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.story.adventure.domain.model.AdventureHint
import com.zenika.story.adventure.presentation.component.AdventureInventoryBag
import com.zenika.story.adventure.presentation.component.ContinentsMap
import com.zenika.story.adventure.presentation.component.ScaffoldScreen
import com.zenika.theme.ScreenPreview
import com.zenika.theme.ZEscapeThemePreview

@Composable
fun PortalScreen(
    state: PortalUiState,
    goToSettings: () -> Unit,
    onPortalClick: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    openHintValidation: (AdventureHint) -> Unit
) {
    ScaffoldScreen(
        modifier = Modifier.clickable(onClick = onPortalClick),
        remainingTime = state.remainingTime,
        goToSettings = goToSettings,
        openHintValidation = { openHintValidation(AdventureHint.PORTAL_HINT) },
        background = R.mipmap.background_neon
    ) {
        ContinentsMap(
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomStart)
                .clickable(onClick = openWorldMap)
        )
        AdventureInventoryBag(
            state.newItem,
            openInventory,
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@ScreenPreview
@Composable
private fun PortalScreenPreview() {
    ZEscapeThemePreview {
        PortalScreen(
            state = PortalUiState(
                portalCanBeOpened = false,
                newItem = false,
                remainingTime = 0
            ),
            goToSettings = {},
            onPortalClick = {},
            openWorldMap = {},
            openInventory = {},
            openHintValidation = {}
        )
    }
}

