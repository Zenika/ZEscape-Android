package com.zenika.story.adventure.presentation.casablanca.meetingroom

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.common.component.ReturnButton
import com.zenika.story.adventure.presentation.casablanca.component.FlashlightScaffoldScreen
import com.zenika.theme.ScreenPreview
import com.zenika.theme.ZEscapeThemePreview

@Composable
fun CasablancaMeetingRoomScreen(
    state: MeetingRoomUiState,
    goBack: () -> Unit,
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    collectPaper: () -> Unit,
    modifier: Modifier = Modifier
) {
    FlashlightScaffoldScreen(
        modifier = modifier,
        remainingTime = state.remainingTime,
        newItem = state.newItem,
        goToSettings = goToSettings,
        background = R.mipmap.casablanca_meeting_room,
        openWorldMap = openWorldMap,
        openInventory = openInventory,
        navigationIcon = { ReturnButton(goBack = goBack) }
    ) {
        if (!state.isCasablancaPaperCollected) {
            Image(
                painter = painterResource(R.mipmap.casablanca_paper),
                contentDescription = stringResource(R.string.casablanca_paper),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 100.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = collectPaper
                    )
            )
        }
    }
}

@ScreenPreview
@Composable
private fun CasablancaMeetingRoomScreenPreview() {
    ZEscapeThemePreview {
        CasablancaMeetingRoomScreen(
            state = MeetingRoomUiState(
                isCasablancaPaperCollected = false,
                remainingTime = 0,
                newItem = false
            ),
            goBack = {},
            goToSettings = {},
            openWorldMap = {},
            openInventory = {},
            collectPaper = {}
        )
    }
}
