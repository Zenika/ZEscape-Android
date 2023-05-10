package com.zenika.tutorial.presentation.component.inventory

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.zenika.R
import com.zenika.ui.theme.screenPadding
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun Inventory(
    openInventory: () -> Unit
) {
    Image(
        painter = painterResource(
            id = R.mipmap.inventory
        ),
        contentDescription = "Inventory",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .padding(screenPadding)
            .clickable { openInventory() }
    )
}

@ComposablePreview
@Composable
fun TreasureChestPreview() {
    ZEscapeThemePreview {
        Inventory(
            openInventory = {}
        )
    }
}