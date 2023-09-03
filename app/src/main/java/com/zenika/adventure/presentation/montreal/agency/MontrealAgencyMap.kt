package com.zenika.adventure.presentation.montreal.agency

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun MontrealAgencyMap(
    isRooftopDiscovered: Boolean,
    isOfficeDiscovered: Boolean,
    goToScan: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Image(
            painter = painterResource(R.mipmap.montreal_map),
            contentDescription = stringResource(R.string.montreal_map),
            modifier = Modifier
                .size(300.dp)
                .align(Alignment.Center)
        )
        Canvas(
            modifier = Modifier
                .padding(start = 23.dp, top = 88.dp)
                .size(132.dp, 87.dp)
                .clickable(isRooftopDiscovered) { goToScan("rooftop") }
        ) {
            drawRect(
                color = if (isRooftopDiscovered) Color.Transparent else Color.Gray
            )
        }
        Canvas(
            modifier = Modifier
                .padding(start = 180.dp, top = 88.dp)
                .size(98.dp, 78.dp)
                .clickable(isOfficeDiscovered) { goToScan("office") }
        ) {
            drawRect(
                color = if (isOfficeDiscovered) Color.Transparent else Color.Gray
            )
        }
        Canvas(
            modifier = Modifier
                .padding(start = 23.dp, top = 175.dp)
                .size(132.dp, 38.dp)
                .clickable { goToScan("library") }
        ) {
            drawRect(
                color = Color.Transparent
            )
        }
        Canvas(
            modifier = Modifier
                .padding(start = 180.dp, top = 165.dp)
                .size(98.dp, 50.dp)
                .clickable { goToScan("meetingroom") }
        ) {
            drawRect(
                color = Color.Transparent
            )
        }
    }
}

@ScreenPreview
@Composable
fun MontrealAgencyMapPreview() {
    ZEscapeThemePreview {
        MontrealAgencyMap(
            isRooftopDiscovered = true,
            isOfficeDiscovered = false,
            goToScan = {}
        )
    }
}
