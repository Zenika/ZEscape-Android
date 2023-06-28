package com.zenika.adventure.presentation.singapore.agency

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.adventure.presentation.component.AdventureInventoryBag
import com.zenika.adventure.presentation.component.ContinentsMap
import com.zenika.adventure.presentation.component.ScaffoldScreen
import com.zenika.ui.theme.screenPadding
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size

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
        background = R.mipmap.singapore_agency
    ) {
        AnimatedVisibility(
            !state.collectSword,
            modifier = Modifier
                .height(300.dp)
                .align(Alignment.TopStart)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null,
                    onClick = collectSword
                )
                .padding(screenPadding),
            exit = fadeOut()
        ) {
            Image(
                painter = painterResource(id = R.mipmap.green_balloon),
                contentDescription = stringResource(R.string.green_balloon)
            )
        }
        AnimatedVisibility(
            !state.collectHook,
            modifier = Modifier
                .height(250.dp)
                .align(Alignment.TopCenter)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null,
                    onClick = collectHook
                )
                .padding(screenPadding),
            exit = fadeOut()
        ) {
            Image(
                painter = painterResource(id = R.mipmap.red_balloon),
                contentDescription = stringResource(R.string.red_balloon)
            )
        }
        AnimatedVisibility(
            !state.collectSingaporeKey,
            modifier = Modifier
                .height(300.dp)
                .align(Alignment.TopEnd)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null,
                    onClick = collectKey
                )
                .padding(screenPadding),
            exit = fadeOut()
        ) {
            Image(
                painter = painterResource(id = R.mipmap.orange_balloon),
                contentDescription = stringResource(R.string.orange_balloon)
            )
        }
        ContinentsMap(
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomStart)
                .clickable(onClick = openWorldMap)
        )
        AdventureInventoryBag(
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomEnd)
                .clickable(onClick = openInventory)
        )
    }
}

@ScreenPreview
@Composable
private fun SingaporeAgencyScreenPreview() {
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