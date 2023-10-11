package com.zenika.story.adventure.presentation.montreal.office

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.story.adventure.presentation.component.AdventureInventoryBag
import com.zenika.story.adventure.presentation.component.ContinentsMap
import com.zenika.story.adventure.presentation.montreal.component.MontrealScaffoldScreen
import com.zenika.theme.ScreenPreview

@Composable
fun MontrealOfficeScreen(
    state: MontrealOfficeUiState,
    goBack: () -> Unit,
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    collectKey: () -> Unit,
    modifier: Modifier = Modifier
) {
    MontrealScaffoldScreen(
        modifier = modifier,
        remainingTime = state.remainingTime,
        goBack = goBack,
        goToSettings = goToSettings,
        background = R.mipmap.montreal_office
    ) {
        if (!state.isMontrealKeyCollected) {
            Image(
                painter = painterResource(R.mipmap.montreal_key),
                contentDescription = stringResource(R.string.montreal_key),
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 275.dp)
                    .size(100.dp)
                    .clickable(onClick = collectKey)
            )
        }
        ContinentsMap(
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomStart)
                .clickable(onClick = openWorldMap)
        )
        AdventureInventoryBag(
            newItem = state.newItem,
            openInventory,
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@ScreenPreview
@Composable
private fun MontrealOfficeScreenPreview() {
    MontrealOfficeScreen(
        state = MontrealOfficeUiState(
            newItem = false,
            isMontrealKeyCollected = false,
            remainingTime = 0
        ),
        goBack = {},
        goToSettings = {},
        openWorldMap = {},
        openInventory = {},
        collectKey = {}
    )
}
