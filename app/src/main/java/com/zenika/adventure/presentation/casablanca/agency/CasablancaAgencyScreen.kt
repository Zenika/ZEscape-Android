package com.zenika.adventure.presentation.casablanca.agency

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
import com.zenika.adventure.presentation.casablanca.component.CasablancaMap
import com.zenika.adventure.presentation.casablanca.component.Safe
import com.zenika.adventure.presentation.casablanca.component.FlashlightScaffoldScreen
import com.zenika.presentation.component.HintButton
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun CasablancaAgencyScreen(
    remainingTime: Int,
    safeState: CasablancaUiState,
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    openAgencyMap: () -> Unit,
    goToSafe: () -> Unit,
    collectKey: () -> Unit,
    modifier: Modifier = Modifier
) {
    FlashlightScaffoldScreen(
        modifier = modifier,
        remainingTime = remainingTime,
        goToSettings = goToSettings,
        background = R.mipmap.casablanca_agency,
        openWorldMap = openWorldMap,
        openInventory = openInventory,
        navigationIcon = { HintButton(onClick = {}) }
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
            safeState,
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
            safeState = CasablancaUiState(isSafeOpen = false, isKeyCollected = false),
            goToSettings = {},
            openWorldMap = {},
            openInventory = {},
            openAgencyMap = {},
            goToSafe = {},
            collectKey = {}
        )
    }
}
