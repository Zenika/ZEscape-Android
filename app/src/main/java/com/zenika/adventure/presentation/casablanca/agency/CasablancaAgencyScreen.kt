package com.zenika.adventure.presentation.casablanca.agency

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.adventure.presentation.casablanca.component.FlashlightScaffoldScreen
import com.zenika.adventure.presentation.component.CasablancaMap
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun CasablancaAgencyScreen(
    remainingTime: Int,
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    openAgencyMap: () -> Unit,
    modifier: Modifier = Modifier
) {
    FlashlightScaffoldScreen(
        modifier = modifier,
        remainingTime = remainingTime,
        goToSettings = goToSettings,
        background = R.mipmap.casablanca_agency,
        openWorldMap = openWorldMap,
        openInventory = openInventory
    ) {
        CasablancaMap(
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterEnd)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null,
                    onClick = openAgencyMap
                )
        )
    }
}

@ScreenPreview
@Composable
private fun CasablancaAgencyScreenPreview() {
    ZEscapeThemePreview {
        CasablancaAgencyScreen(
            remainingTime = 3_600,
            goToSettings = {},
            openWorldMap = {},
            openInventory = {},
            openAgencyMap = {}
        )
    }
}
