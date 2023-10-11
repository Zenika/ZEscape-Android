package com.zenika.story.adventure.presentation.montreal.meetingroom

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.story.adventure.presentation.component.AdventureInventoryBag
import com.zenika.story.adventure.presentation.component.ContinentsMap
import com.zenika.story.adventure.presentation.montreal.component.MontrealScaffoldScreen
import com.zenika.theme.ScreenPreview

@Composable
fun MontrealMeetingRoomScreen(
    state: MontrealMeetingRoomUiState,
    goBack: () -> Unit,
    goToSettings: () -> Unit,
    onButtonClick: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    modifier: Modifier = Modifier
) {
    MontrealScaffoldScreen(
        modifier = modifier,
        remainingTime = state.remainingTime,
        goBack = goBack,
        goToSettings = goToSettings,
        background = R.mipmap.montreal_meetingroom
    ) {
        Button(
            onClick = onButtonClick,
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Text(text = stringResource(R.string.desk))
        }
        ContinentsMap(
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomStart)
                .clickable(onClick = openWorldMap)
        )
        AdventureInventoryBag(
            newItem = state.newItem,
            openInventory = openInventory,
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@ScreenPreview
@Composable
private fun MontrealMeetingRoomScreenPreview() {
    MontrealMeetingRoomScreen(
        state = MontrealMeetingRoomUiState(
            newItem = false,
            isDoorOpen = false,
            remainingTime = 0
        ),
        goBack = {},
        goToSettings = {},
        onButtonClick = {},
        openWorldMap = {},
        openInventory = {}
    )
}
