package com.zenika.adventure.presentation.final_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.zenika.R
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun FinalScreen() {
    Image(
        painter = painterResource(
            id = R.mipmap.computer
        ),
        contentDescription = stringResource(R.string.computer_image),
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillHeight
    )
}

@ScreenPreview
@Composable
fun FinalScreenPreview() {
    ZEscapeThemePreview {
        FinalScreen()
    }
}