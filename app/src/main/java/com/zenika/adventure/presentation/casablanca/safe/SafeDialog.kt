package com.zenika.adventure.presentation.casablanca.safe

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.zenika.R
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

private const val COLUMNS_COUNT = 3
private const val NUMBERS = 9

@Composable
fun SafeDialog(
    onDismissRequest: () -> Unit,
    code: String,
    addNumber: (String) -> Unit,
    clearNumber: () -> Unit,
    checkCode: () -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.mipmap.mecanism),
                contentDescription = stringResource(R.string.close_safe),
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Column {
                Text(
                    text = code,
                    modifier = Modifier
                        .width(100.dp)
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .border(4.dp, MaterialTheme.colorScheme.primary)
                        .align(CenterHorizontally),
                    textAlign = TextAlign.Center
                )
                LazyVerticalGrid(
                    columns = GridCells.Fixed(COLUMNS_COUNT),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(NUMBERS) {
                        val number = it + 1
                        Button(onClick = { addNumber(number.toString()) }) {
                            Text(text = number.toString())
                        }
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(
                        8.dp, CenterHorizontally
                    )
                ) {
                    Button(onClick = clearNumber) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.clear)
                        )
                    }
                    Button(onClick = checkCode) {
                        Text(text = stringResource(R.string.ok))
                    }
                }
            }
        }
    }
}

@ComposablePreview
@Composable
private fun SafeDialogPreview() {
    ZEscapeThemePreview {
        SafeDialog(
            onDismissRequest = {},
            code = "123",
            addNumber = {},
            clearNumber = {},
            checkCode = {}
        )
    }
}
