package com.zenika.adventure.presentation.world_map

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
                    painter = painterResource(id = R.mipmap.world_map),
                    contentDescription = stringResource(R.string.world_map)
                )
                if (agencies.contains(Agency.CASABLANCA)) {
                    Canvas(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(top = 12.dp, end = 20.dp)
                            .clickable { Log.d("city", Agency.CASABLANCA.name) }
                    ) {
                        drawCircle(Color.Red, radius = 10.dp.toPx())
                    }
                }
                if (agencies.contains(Agency.PARIS)) {
                    Canvas(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(bottom = 40.dp)
                            .clickable { Log.d("city", Agency.PARIS.name) }
                    ) {
                        drawCircle(Color.Red, radius = 10.dp.toPx())
                    }
                }
                if (agencies.contains(Agency.SINGAPOUR)) {
                    Canvas(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(start = 160.dp, top = 20.dp)
                            .clickable { Log.d("city", Agency.SINGAPOUR.name) }
                    ) {
                        drawCircle(Color.Red, radius = 10.dp.toPx())
                    }
                }
                if (agencies.contains(Agency.MONTREAL)) {
                    Canvas(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(end = 160.dp, bottom = 80.dp)
                            .clickable { Log.d("city", Agency.MONTREAL.name) }
                    ) {
                        drawCircle(Color.Red, radius = 10.dp.toPx())
                    }
                }
            }
            Button(onClick = openTextRecognition) {
                Text(text = stringResource(R.string.add_agency))
            }
        }
    }
}

@ScreenPreview
@Composable
private fun WorldMapDialogPreview() {
    ZEscapeThemePreview {
        WorldMapDialog(
            onDismissRequest = {},
            openTextRecognition = {},
            agencies = mutableSetOf(Agency.MONTREAL)
        )
    }
}