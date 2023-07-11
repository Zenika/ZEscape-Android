package com.zenika.adventure.presentation.world_map

import android.util.Log
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
import com.zenika.data.Agency
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun WorldMapDialog(
    onDismissRequest: () -> Unit,
    openTextRecognition: () -> Unit,
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
                            .clickable { Log.d("city", Agency.CASABLANCA.name) }
                    )
                }
                if (Agency.PARIS in agencies) {
                    CityCircle(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(bottom = 40.dp)
                            .clickable { Log.d("city", Agency.PARIS.name) }
                    )
                }
                if (Agency.SINGAPOUR in agencies) {
                    CityCircle(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(start = 160.dp, top = 20.dp)
                            .clickable { Log.d("city", Agency.SINGAPOUR.name) }
                    )
                }
                if (Agency.MONTREAL in agencies) {
                    CityCircle(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(end = 160.dp, bottom = 80.dp)
                            .clickable { Log.d("city", Agency.MONTREAL.name) }
                    )
                }
            }
            Button(onClick = openTextRecognition) {
                Text(text = stringResource(R.string.add_agency))
            }
        }
    }
}

@Composable
private fun CityCircle(modifier: Modifier) {
    Canvas(
        modifier = modifier
    ) {
        drawCircle(Color.Red, radius = 10.dp.toPx())
    }
}

@ScreenPreview
@Composable
private fun WorldMapDialogPreview() {
    ZEscapeThemePreview {
        WorldMapDialog(
            onDismissRequest = {},
            openTextRecognition = {},
            agencies = mutableSetOf(
                Agency.MONTREAL,
                Agency.CASABLANCA,
                Agency.PARIS,
                Agency.SINGAPOUR
            )
        )
    }
}