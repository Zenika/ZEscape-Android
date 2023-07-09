package com.zenika.tutorial.presentation.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.zenika.R
import com.zenika.ui.theme.screenPadding
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun TutorialInventoryBag(
    modifier: Modifier,
    newItem: Boolean,
    openInventory: () -> Unit,
    removeNewItemBadge: () -> Unit
) {
    val imageRes = if (newItem) {
        R.mipmap.inventory_with_badge
    } else {
        R.mipmap.inventory
    }

    Image(
        painter = painterResource(
            id = imageRes
        ),
        contentDescription = stringResource(R.string.inventory_bag_image),
        contentScale = ContentScale.Fit,
        modifier = modifier
            .padding(screenPadding)
            .clickable {
                openInventory()
                removeNewItemBadge()
            },
    )
}

@ComposablePreview
@Composable
private fun InventoryBagPreview() {
    ZEscapeThemePreview {
        TutorialInventoryBag(
            modifier = Modifier,
            newItem = false,
            openInventory = {},
            removeNewItemBadge = {}
        )
    }
}

@ComposablePreview
@Composable
private fun InventoryBagWithBadgePreview() {
    ZEscapeThemePreview {
        TutorialInventoryBag(
            modifier = Modifier,
            newItem = true,
            openInventory = {},
            removeNewItemBadge = {}
        )
    }
}
