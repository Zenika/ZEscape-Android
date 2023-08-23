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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
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

@Composable
fun SingaporeAgencyScreen(
    state: SingaporeUiState,
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    collectKey: () -> Unit,
    collectSword: () -> Unit,
    collectHook: () -> Unit,
    modifier: Modifier = Modifier
) {
    ScaffoldScreen(
        modifier = modifier,
        remainingTime = state.remainingTime,
        goToSettings = goToSettings,
        background = R.mipmap.singapore_agency
    ) {
        Balloon(
            isCollected = state.isSwordCollected,
            collect = collectSword,
            painter = painterResource(R.mipmap.green_balloon),
            contentDescription = stringResource(R.string.green_balloon),
            modifier = Modifier
                .height(300.dp)
                .align(Alignment.TopStart)
        )
        Balloon(
            isCollected = state.isHookCollected,
            collect = collectHook,
            painter = painterResource(R.mipmap.red_balloon),
            contentDescription = stringResource(R.string.red_balloon),
            modifier = Modifier
                .height(250.dp)
                .align(Alignment.TopCenter)
        )
        Balloon(
            isCollected = state.isSingaporeKeyCollected,
            collect = collectKey,
            painter = painterResource(R.mipmap.orange_balloon),
            contentDescription = stringResource(R.string.orange_balloon),
            modifier = Modifier
                .height(300.dp)
                .align(Alignment.TopEnd)
        )
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

@Composable
private fun Balloon(
    isCollected: Boolean,
    collect: () -> Unit,
    painter: Painter,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(
        !isCollected,
        modifier = modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = collect
            )
            .padding(screenPadding),
        exit = fadeOut()
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription
        )
    }
}

@ScreenPreview
@Composable
private fun SingaporeAgencyScreenPreview() {
    ZEscapeThemePreview {
        SingaporeAgencyScreen(
            state = SingaporeUiState(
                isSingaporeKeyCollected = true,
                isSwordCollected = false,
                isHookCollected = false,
                remainingTime = 0
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
