package com.zenika.tutorial.presentation.item

import androidx.compose.runtime.Composable
import com.zenika.R
import com.zenika.tutorial.presentation.component.TutorialDialog
import com.zenika.tutorial.presentation.item.component.TutorialItem
import com.zenika.tutorial.presentation.item.component.WelcomeParchmentItem
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun TutorialItemDialog(
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
