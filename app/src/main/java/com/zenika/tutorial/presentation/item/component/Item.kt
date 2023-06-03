package com.zenika.tutorial.presentation.item.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.zenika.R
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun Item(
    item: Int
) {
    Image(
        painter = painterResource(
            id = item
        ),
        contentDescription = "Item in inventory"
    )
}

@ScreenPreview
@Composable
fun ItemDialogPreview() {
    ZEscapeThemePreview {
        Item(
            item = R.mipmap.paper
        )
    }
}
