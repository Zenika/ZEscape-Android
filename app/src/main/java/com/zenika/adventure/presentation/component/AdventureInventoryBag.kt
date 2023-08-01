package com.zenika.adventure.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.zenika.R
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun AdventureInventoryBag(
    newItem: Boolean,
    openInventory: () -> Unit,
    removeNewItemBadge: () -> Unit,
    modifier: Modifier = Modifier
) {
    val imageRes = if (newItem) {
        R.mipmap.newitem_suitcase
    } else {
        R.mipmap.suitcase
    }

    Image(
        painter = painterResource(imageRes),
        contentDescription = stringResource(R.string.inventory_bag_image),
        contentScale = ContentScale.Fit,
        modifier = modifier.clickable(onClick = {
            removeNewItemBadge()
            openInventory()
        })
    )
}

@ComposablePreview
@Composable
private fun AdventureInventoryBagPreview() {
    ZEscapeThemePreview {
        AdventureInventoryBag(
            newItem = false,
            openInventory = {},
            removeNewItemBadge = {}
        )
    }
}
