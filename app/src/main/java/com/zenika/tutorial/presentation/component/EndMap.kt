package com.zenika.tutorial.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.tutorial.presentation.TutorialViewModel
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun EndMap(
    finishGame: () -> Unit
) {
    Box(
        Modifier
            .fillMaxSize()
            .padding()
            .paint(
                painterResource(id = R.mipmap.sea_background),
                contentScale = ContentScale.FillHeight
            )
    ) {
        Image(
            painter = painterResource(
                id = R.mipmap.treasure_map
            ),
            contentDescription = "Treasure Map with a mysterious message",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxSize()
                .clickable { finishGame() }
        )
        Text(
            text = stringResource(id = R.string.end_map),
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 60.dp, start = 70.dp, end = 70.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@ScreenPreview
@Composable
fun EndMapPreview() {
    ZEscapeThemePreview {
        GameDialog(
            viewModel = TutorialViewModel(),
            onDismissRequest = {}
        )
    }
}
