package com.zenika.adventure.presentation.final_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.zenika.R
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun FinalScreen(goToScore: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    )
    {
        Image(
            painter = painterResource(
                id = R.mipmap.computer
            ),
            contentDescription = stringResource(R.string.computer_final_image),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillHeight
        )
        Button(onClick = goToScore,
            modifier = Modifier
                .align(Alignment.Center)) {
            Text(text = stringResource(R.string.score))
        }
    }

}

@ScreenPreview
@Composable
fun FinalScreenPreview() {
    ZEscapeThemePreview {
        FinalScreen(goToScore = {})
    }
}