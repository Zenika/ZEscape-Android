package com.zenika.adventure.presentation.casablanca.agency_map

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.zenika.R
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun AgencyMapDialog(
    onDismissRequest: () -> Unit,
    goToRestRoom: () -> Unit,
    goToKitchen: () -> Unit,
    goToOffices: () -> Unit,
    goToMeetingRoom: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box {
                Image(
                    painter = painterResource(R.mipmap.casablanca_map),
                    contentDescription = stringResource(R.string.world_map)
                )
                Canvas(
                    modifier = Modifier
                        .padding(start = 28.dp, top = 28.dp)
                        .size(136.dp, 92.dp)
                        .clickable(onClick = goToOffices)
                ) {
                    drawRect(
                        color = Color.Transparent
                    )
                }
                Canvas(
                    modifier = Modifier
                        .padding(start = 192.dp, top = 28.dp)
                        .size(100.dp, 80.dp)
                        .clickable(onClick = goToMeetingRoom)
                ) {
                    drawRect(
                        color = Color.Transparent
                    )
                }
                Canvas(
                    modifier = Modifier
                        .padding(start = 28.dp, top = 124.dp)
                        .size(136.dp, 40.dp)
                        .clickable(onClick = goToRestRoom)
                ) {
                    drawRect(
                        color = Color.Transparent
                    )
                }
                Canvas(
                    modifier = Modifier
                        .padding(start = 192.dp, top = 112.dp)
                        .size(100.dp, 52.dp)
                        .clickable(onClick = goToKitchen)
                ) {
                    drawRect(
                        color = Color.Transparent
                    )
                }
            }
        }
    }
}

@ScreenPreview
@Composable
private fun AgencyMapDialogPreview() {
    ZEscapeThemePreview {
        AgencyMapDialog(
            onDismissRequest = {},
            goToRestRoom = {},
            goToKitchen = {},
            goToOffices = {},
            goToMeetingRoom = {}
        )
    }
}