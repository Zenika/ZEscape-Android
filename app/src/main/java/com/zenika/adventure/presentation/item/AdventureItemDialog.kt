package com.zenika.adventure.presentation.item

import androidx.compose.runtime.Composable
import com.zenika.R
import com.zenika.adventure.presentation.item.component.AdventureItem
import com.zenika.tutorial.presentation.component.TutorialDialog
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun AdventureItemDialog(
    item: Int,
    onDismissRequest: () -> Unit
) {
    TutorialDialog(
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
            item = R.mipmap.parchment,
            onDismissRequest = {}
        )
    }
}
