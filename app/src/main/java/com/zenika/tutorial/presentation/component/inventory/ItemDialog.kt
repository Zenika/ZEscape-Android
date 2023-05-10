package com.zenika.tutorial.presentation.component.inventory

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.zenika.R
import com.zenika.tutorial.domain.ItemViewModel
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun ItemDialog(
    viewModel: ItemViewModel = hiltViewModel(),
    onDismissRequest: () -> Unit,
    openEndMap: () -> Unit
) {
    val item by viewModel.item.collectAsState()
    if (item == R.mipmap.rolled_map) {
        openEndMap()
    } else {
        Dialog(
            onDismissRequest = onDismissRequest,
            properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
        ) {
            ItemContent(item)
        }
    }
}

@Composable
private fun ItemContent(
    item: Int
) {
    Image(
        painter = painterResource(
            id = item
        ),
        contentDescription = "Item in inventory"
    )
}

@ScreenPreview
@Composable
fun ItemDialogPreview() {
    ZEscapeThemePreview {
        ItemContent(
            item = R.mipmap.paper
        )
    }
}
