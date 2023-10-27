package com.zenika.story.adventure.presentation.item

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import com.zenika.R
import com.zenika.story.adventure.presentation.component.AdventureDialog
import com.zenika.story.adventure.presentation.item.component.AdventureItem
import com.zenika.theme.ScreenPreview
import com.zenika.theme.ZEscapeThemePreview

@Composable
fun AdventureItemDialog(
    @DrawableRes
    item: Int,
    onDismissRequest: () -> Unit
) {
    AdventureDialog(
        onDismissRequest = onDismissRequest,
        backgroundColor = null
    ) {
        AdventureItem(item)
    }
}

@ScreenPreview
@Composable
private fun AdventureItemDialogPreview() {
    ZEscapeThemePreview {
        AdventureItemDialog(
            item = R.mipmap.hook,
            onDismissRequest = {}
        )
    }
}
