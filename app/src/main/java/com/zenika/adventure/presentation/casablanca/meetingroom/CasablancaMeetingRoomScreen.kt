package com.zenika.adventure.presentation.casablanca.meetingroom

import android.os.Build.VERSION_CODES
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.adventure.presentation.casablanca.component.FlashlightScaffoldScreen
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@RequiresApi(VERSION_CODES.M)
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
        goToSettings = goToSettings,
        background = R.mipmap.casablanca_meeting_room,
        openWorldMap = openWorldMap,
        openInventory = openInventory,
        goBack = goBack
    ) {
        if (!state.isCasablancaPaperCollected) {
            Image(
                painter = painterResource(R.mipmap.casablanca_paper),
                contentDescription = stringResource(R.string.casablanca_paper),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 100.dp)
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null,
                        onClick = collectPaper
                    )
            )
        }
    }
}

@RequiresApi(VERSION_CODES.M)
@ScreenPreview
@Composable
private fun CasablancaMeetingRoomScreenPreview() {
    ZEscapeThemePreview {
        CasablancaMeetingRoomScreen(
            state = MeetingRoomUiState(
                isCasablancaPaperCollected = false,
                remainingTime = 0
            ),
            goBack = {},
            goToSettings = {},
            openWorldMap = {},
            openInventory = {},
            collectPaper = {}
        )
    }
}
