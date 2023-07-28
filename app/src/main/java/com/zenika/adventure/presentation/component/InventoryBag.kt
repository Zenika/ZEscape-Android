package com.zenika.adventure.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.zenika.R
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun InventoryBag(
    modifier: Modifier
) {
    Image(
        painter = painterResource(
            id = R.mipmap.suitcase
        ),
        contentDescription = stringResource(R.string.inventory_bag_image),
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}

@ComposablePreview
@Composable
fun InventoryBagPreview() {
    ZEscapeThemePreview {
        InventoryBag(
            modifier = Modifier
        )
    }
}