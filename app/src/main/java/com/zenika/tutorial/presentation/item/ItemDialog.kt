package com.zenika.tutorial.presentation.item

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.zenika.R
import com.zenika.tutorial.presentation.item.component.Item
import com.zenika.tutorial.presentation.item.component.WelcomeParchmentItem
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun ItemDialog(
    item: Int,
    onDismissRequest: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        when (item) {
            R.mipmap.parchment -> {
                WelcomeParchmentItem(onDismissRequest)
            }
            else -> {
                Item(item)
            }
        }
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
