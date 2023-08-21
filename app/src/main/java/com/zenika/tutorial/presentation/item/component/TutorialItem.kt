package com.zenika.tutorial.presentation.item.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.zenika.R
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun TutorialItem(
    @DrawableRes
    item: Int
) {
    Image(
        painter = painterResource(item),
        contentDescription = stringResource(R.string.item_image)
    )
}

@ComposablePreview
@Composable
private fun TutorialItemPreview() {
    ZEscapeThemePreview {
        TutorialItem(
            item = R.mipmap.paper
        )
    }
}
