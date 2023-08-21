package com.zenika.adventure.presentation.casablanca.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.zenika.R
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun CasablancaAgencyMapDialog(
    onDismissRequest: () -> Unit,
    goToRestRoom: () -> Unit,
    goToKitchen: () -> Unit,
    goToOffices: () -> Unit,
    goToMeetingRoom: () -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        Box(modifier) {
            Image(
                painter = painterResource(R.mipmap.casablanca_map),
                contentDescription = stringResource(R.string.casablanca_map)
            )
            Box(
                modifier = Modifier
                    .padding(start = 26.dp, top = 28.dp)
                    .size(140.dp, 92.dp)
                    .clickable(onClick = goToOffices)
            )
            Box(
                modifier = Modifier
                    .padding(start = 192.dp, top = 28.dp)
                    .size(100.dp, 80.dp)
                    .clickable(onClick = goToMeetingRoom)
            )
            Box(
                modifier = Modifier
                    .padding(start = 26.dp, top = 124.dp)
                    .size(140.dp, 40.dp)
                    .clickable(onClick = goToRestRoom)
            )
            Box(
                modifier = Modifier
                    .padding(start = 192.dp, top = 112.dp)
                    .size(100.dp, 52.dp)
                    .clickable(onClick = goToKitchen)
            )
        }
    }
}

@ScreenPreview
@Composable
private fun AgencyMapDialogPreview() {
    ZEscapeThemePreview {
        CasablancaAgencyMapDialog(
            onDismissRequest = {},
            goToRestRoom = {},
            goToKitchen = {},
            goToOffices = {},
            goToMeetingRoom = {}
        )
    }
}
