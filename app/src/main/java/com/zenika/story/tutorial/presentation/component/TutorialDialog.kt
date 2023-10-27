package com.zenika.story.tutorial.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.zenika.R
import com.zenika.theme.ComposablePreview
import com.zenika.theme.ZEscapeThemePreview
import com.zenika.theme.dialogPadding
import com.zenika.theme.screenPadding
import com.zenika.theme.tutorialBodyMedium

@Composable
fun TutorialDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    backgroundColor: Color? = MaterialTheme.colorScheme.primaryContainer,
    content: @Composable BoxScope.() -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        Box(
            modifier
                .fillMaxSize()
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = onDismissRequest
                )
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .dialogBackground(
                        color = backgroundColor,
                        borderColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        shape = MaterialTheme.shapes.extraLarge
                    )
            ) {
                content()
            }
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

@ComposablePreview
@Composable
private fun TutorialDialogPreview() {
    ZEscapeThemePreview {
        TutorialDialog(onDismissRequest = { }) {
            Text(
                text = stringResource(R.string.instruction),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = tutorialBodyMedium
            )
        }
    }
}

