package com.zenika.feature1.presentation.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.zenika.R
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun Count(
    count: Int?,
    modifier: Modifier
) {
    Text(
        text = when (count) {
            null -> stringResource(R.string.feature1_noCount)
            else -> stringResource(R.string.feature1_count, count)
        },
        modifier = modifier,
        style = MaterialTheme.typography.bodyLarge
    )
}

@ComposablePreview
@Composable
fun CountPreview() {
    ZEscapeThemePreview {
        Count(
            1988,
            Modifier
        )
    }
}

@ComposablePreview
@Composable
fun NoCountPreview() {
    ZEscapeThemePreview {
        Count(
            null,
            Modifier
        )
    }
}