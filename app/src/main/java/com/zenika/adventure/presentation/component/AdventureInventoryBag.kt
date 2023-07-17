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
fun AdventureInventoryBag(
    modifier: Modifier
) {
    Image(
        painter = painterResource(R.mipmap.suitcase),
        contentDescription = stringResource(R.string.inventory_bag_image),
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}

@ComposablePreview
@Composable
private fun AdventureInventoryBagPreview() {
    ZEscapeThemePreview {
        AdventureInventoryBag(
            modifier = Modifier
        )
    }
}