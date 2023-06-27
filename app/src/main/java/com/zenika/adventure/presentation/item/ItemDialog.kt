package com.zenika.adventure.presentation.item

import androidx.compose.runtime.Composable
import com.zenika.R
import com.zenika.adventure.presentation.item.component.Item
import com.zenika.tutorial.presentation.component.TutorialDialog
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun ItemDialog(
    item: Int,
    onDismissRequest: () -> Unit
) {
    TutorialDialog(
        onDismissRequest = onDismissRequest,
        backgroundColor = null
    ) {
        Item(item)
    }
}

@ScreenPreview
@Composable
fun ItemDialogPreview() {
    ZEscapeThemePreview {
        ItemDialog(
            item = R.mipmap.parchment,
            onDismissRequest = {}
        )
    }
}
