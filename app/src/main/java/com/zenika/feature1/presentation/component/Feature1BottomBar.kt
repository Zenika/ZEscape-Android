package com.zenika.feature1.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun Feature1BottomBar(
    modifier: Modifier,
    onIncrement: () -> Unit,
    onGoToNext: () -> Unit
) {
    Row(
        modifier = modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(
            modifier = Modifier.weight(1f),
            onClick = onIncrement
        ) {
            Text(stringResource(R.string.feature1_increment))
        }
        Button(
            modifier = Modifier.weight(1f),
            onClick = onGoToNext
        ) {
            Text(stringResource(R.string.feature1_goToNext))
        }
    }
}

@ComposablePreview
@Composable
fun Feature1BottomBarPreview() {
    ZEscapeThemePreview {
        Feature1BottomBar(
            modifier = Modifier.fillMaxWidth(),
            onIncrement = {},
            onGoToNext = {}
        )
    }
}