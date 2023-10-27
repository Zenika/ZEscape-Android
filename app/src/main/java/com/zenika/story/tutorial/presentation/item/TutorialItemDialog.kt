package com.zenika.story.tutorial.presentation.item

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import com.zenika.R
import com.zenika.story.tutorial.presentation.component.TutorialDialog
import com.zenika.story.tutorial.presentation.item.component.TutorialItem
import com.zenika.story.tutorial.presentation.item.component.WelcomeParchmentItem
import com.zenika.theme.ComposablePreview
import com.zenika.theme.ZEscapeThemePreview

@Composable
fun TutorialItemDialog(
    @DrawableRes
    item: Int,
    onDismissRequest: () -> Unit
) {
    TutorialDialog(
        onDismissRequest = onDismissRequest,
        backgroundColor = null
    ) {
        when (item) {
            R.mipmap.parchment -> {
                WelcomeParchmentItem(onDismissRequest)
            }

            else -> {
                TutorialItem(item)
            }
        }
    }
}

@ComposablePreview
@Composable
private fun TutorialItemDialogPreview() {
    ZEscapeThemePreview {
        TutorialItemDialog(
            item = R.mipmap.parchment,
            onDismissRequest = {}
        )
    }
}
