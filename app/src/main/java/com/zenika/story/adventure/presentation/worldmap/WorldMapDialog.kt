package com.zenika.story.adventure.presentation.worldmap

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
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
import com.zenika.story.adventure.domain.model.Agency
import com.zenika.theme.ComposablePreview
import com.zenika.theme.ZEscapeThemePreview

@Composable
fun WorldMapDialog(
    onDismissRequest: () -> Unit,
    openTextRecognition: () -> Unit,
    goBackToPortal: () -> Unit,
    goToSingaporeAgency: () -> Unit,
    goToCasablancaAgency: () -> Unit,
    goToMontrealAgency: () -> Unit,
    openAgencyTeaser: () -> Unit,
    agencies: Set<Agency>
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
                    painter = painterResource(R.mipmap.world_map),
                    contentDescription = stringResource(R.string.world_map),
                    modifier = Modifier.width(400.dp)
                )
                if (Agency.CASABLANCA in agencies) {
                    CityCircle(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(top = 12.dp, end = 20.dp)
                            .clickable(onClick = goToCasablancaAgency)
                    )
                }
                if (Agency.PARIS in agencies) {
                    CityCircle(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(bottom = 60.dp)
                            .clickable(onClick = openAgencyTeaser)
                    )
                }
                if (Agency.SINGAPOUR in agencies) {
                    CityCircle(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(start = 160.dp, top = 20.dp)
                            .clickable(onClick = goToSingaporeAgency)
                    )
                }
                if (Agency.MONTREAL in agencies) {
                    CityCircle(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(end = 160.dp, bottom = 80.dp)
                            .clickable(onClick = goToMontrealAgency)
                    )
                }
            }
            Button(onClick = openTextRecognition) {
                Text(text = stringResource(R.string.add_agency))
            }
            Button(onClick = goBackToPortal) {
                Text(text = stringResource(R.string.goBackToPortal))
            }
        }
    }
}

@Composable
private fun CityCircle(modifier: Modifier) {
    Canvas(
        modifier = modifier
    ) {
        drawCircle(Color.Red, radius = 16.dp.toPx())
    }
}

@ComposablePreview
@Composable
private fun WorldMapDialogPreview() {
    ZEscapeThemePreview {
        WorldMapDialog(
            onDismissRequest = {},
            openTextRecognition = {},
            goBackToPortal = {},
            goToSingaporeAgency = {},
            goToCasablancaAgency = {},
            goToMontrealAgency = {},
            openAgencyTeaser = {},
            agencies = mutableSetOf(Agency.MONTREAL, Agency.CASABLANCA, Agency.PARIS)
        )
    }
}

