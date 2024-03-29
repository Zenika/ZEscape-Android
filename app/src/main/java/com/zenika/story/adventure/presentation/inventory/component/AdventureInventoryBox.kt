package com.zenika.story.adventure.presentation.inventory.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.theme.ScreenPreview
import com.zenika.theme.ZEscapeThemePreview
import com.zenika.theme.dialogPadding
import com.zenika.theme.itemDialogPadding

@Composable
fun AdventureInventoryBox(
    @DrawableRes
    item: Int,
    onItemClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 100.dp
) {
    Box(
        modifier = modifier
            .size(size)
            .padding(itemDialogPadding)
            .clip(shape = RoundedCornerShape(percent = 25))
            .border(
                border = BorderStroke(2.dp, Color.Black),
                shape = RoundedCornerShape(percent = 25)
            )
            .padding(1.dp)
            .background(MaterialTheme.colorScheme.primary)
            .clickable(enabled = item != 0) { onItemClick(item) }
            .wrapContentSize(Alignment.Center)
            .padding(dialogPadding)
    ) {
        if (item != 0) {
            Image(
                painter = painterResource(item),
                contentDescription = stringResource(R.string.item_image)
            )
        }
    }
}

@ScreenPreview
@Composable
private fun AdventureInventoryBoxPreview() {
    ZEscapeThemePreview {
        Row {
            AdventureInventoryBox(
                item = R.mipmap.hook,
                onItemClick = {}
            )
            AdventureInventoryBox(
                item = 0,
                onItemClick = {}
            )
        }
    }
}
