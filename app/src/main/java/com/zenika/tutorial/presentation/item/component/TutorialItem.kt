package com.zenika.tutorial.presentation.item.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.zenika.R
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun TutorialItem(
    item: Int
) {
    Image(
        painter = painterResource(
            id = item
        ),
        contentDescription = stringResource(R.string.item_image)
    )
}

@ScreenPreview
@Composable
private fun TutorialItemPreview() {
    ZEscapeThemePreview {
        TutorialItem(
            item = R.mipmap.paper
        )
    }
}
