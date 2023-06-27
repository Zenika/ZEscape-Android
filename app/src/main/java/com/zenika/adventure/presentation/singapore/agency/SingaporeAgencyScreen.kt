package com.zenika.adventure.presentation.singapore.agency

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.adventure.presentation.component.ContinentsMap
import com.zenika.adventure.presentation.component.InventoryBag
import com.zenika.adventure.presentation.component.ScaffoldScreen
import com.zenika.ui.theme.screenPadding
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun SingaporeAgencyScreen(
    state: SingaporeUiState,
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    collectKey: () -> Unit,
    collectSword: () -> Unit,
    collectHook: () -> Unit
) {
    ScaffoldScreen(
        remainingTime = state.remainingTime,
        goToSettings = goToSettings,
        onClick = {},
        background = R.mipmap.singapore_agency
    ) {
        if (!state.collectSword) {
            Image(
                painter = painterResource(id = R.mipmap.green_balloon),
                contentDescription = "Ballon vert avec épée accrochée au bout",
                modifier = Modifier
                    .height(300.dp)
                    .align(Alignment.TopStart)
                    .clickable { collectSword() }
                    .padding(screenPadding)
            )
        }
        if (!state.collectHook) {
            Image(
                painter = painterResource(id = R.mipmap.red_balloon),
                contentDescription = "Ballon rouge avec crochet accroché au bout",
                modifier = Modifier
                    .height(250.dp)
                    .align(Alignment.TopCenter)
                    .clickable { collectHook() }
                    .padding(screenPadding)
            )
        }
        if (!state.collectSingaporeKey) {
            Image(
                painter = painterResource(id = R.mipmap.blue_balloon),
                contentDescription = "Ballon bleu avec clé accrochée au bout",
                modifier = Modifier
                    .height(300.dp)
                    .align(Alignment.TopEnd)
                    .clickable { collectKey() }
                    .padding(screenPadding)
            )
        }
        ContinentsMap(
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.BottomStart)
                .clickable { openWorldMap() }
                .padding(screenPadding)
        )
        InventoryBag(
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.BottomEnd)
                .clickable { openInventory() }
                .padding(screenPadding)
        )
    }
}

@ScreenPreview
@Composable
fun SingaporeAgencyScreenPreview() {
    ZEscapeThemePreview {
        SingaporeAgencyScreen(
            state = SingaporeUiState(
                collectSingaporeKey = true,
                collectSword = false,
                collectHook = false,
                remainingTime = 36000
            ),
            goToSettings = {},
            openWorldMap = {},
            openInventory = {},
            collectKey = {},
            collectSword = {},
            collectHook = {}
        )
    }
}