package com.zenika.tutorial.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.zenika.ui.theme.dialogPadding
import com.zenika.ui.theme.screenPadding

@Composable
fun TutorialDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    backgroundColor: Color? = MaterialTheme.colorScheme.primaryContainer,
    content: @Composable BoxScope.() -> Unit
) {

    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        Box(
            modifier
                .fillMaxWidth()
                .dialogBackground(
                    color = backgroundColor,
                    borderColor= MaterialTheme.colorScheme.onPrimaryContainer,
                    shape = MaterialTheme.shapes.extraLarge
                )
        ) {
            content()
        }
    }
}

private fun Modifier.dialogBackground(
    color: Color?,
    borderColor: Color,
    shape: Shape
): Modifier {
    return then(
        if (color != null) {
            val withBackgroundModifier = Modifier
                .padding(screenPadding)
                .border(
                    width = 2.dp,
                    color = borderColor,
                    shape = shape
                )
                .padding(1.dp)
                .background(
                    color,
                    shape
                )
                .padding(dialogPadding)
            withBackgroundModifier
        } else Modifier
    )
}

