package com.zenika.adventure.presentation.item.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.zenika.R
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun AdventureItem(
    item: Int
) {
    Image(
        painter = painterResource(item),
        contentDescription = stringResource(R.string.item_image)
    )
}

@ScreenPreview
@Composable
fun AdventureItemPreview() {
    ZEscapeThemePreview {
        AdventureItem(
            item = R.mipmap.hook
        )
    }
}
