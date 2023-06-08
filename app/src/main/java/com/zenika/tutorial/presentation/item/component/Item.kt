package com.zenika.tutorial.presentation.item.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
        contentDescription = stringResource(id = R.string.item_image)
    )
}

@ScreenPreview
@Composable
fun ItemPreview() {
    ZEscapeThemePreview {
        Item(
            item = R.mipmap.paper
        )
    }
}
