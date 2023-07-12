package com.zenika.tutorial.presentation.inventory.component

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
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.ui.theme.dialogPadding
import com.zenika.ui.theme.itemDialogPadding
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun TutorialInventoryBox(
    item: Int,
    showItem: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .padding(itemDialogPadding)
            .clip(shape = RoundedCornerShape(25))
            .border(border = BorderStroke(2.dp, Color.Black), shape = RoundedCornerShape(25))
            .background(MaterialTheme.colorScheme.primary)
            .clickable(enabled = item != 0) { showItem(item) }
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

@ComposablePreview
@Composable
private fun TutorialInventoryBoxPreview() {
    ZEscapeThemePreview {
        Row {
            TutorialInventoryBox(
                item = R.mipmap.parchment,
                showItem = {}
            )
            TutorialInventoryBox(
                item = 0,
                showItem = {}
            )
        }
    }
}
