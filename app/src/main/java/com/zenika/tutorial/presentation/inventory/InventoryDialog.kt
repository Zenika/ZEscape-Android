package com.zenika.tutorial.presentation.inventory

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.zenika.R
import com.zenika.data.model.ItemDto
import com.zenika.ui.theme.InventoryBoxColor
import com.zenika.ui.theme.dialogPadding
import com.zenika.ui.theme.itemDialogPadding
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun InventoryDialog(
    modifier: Modifier,
    items: List<ItemDto>,
    showItem: (Int) -> Unit,
    onDismissRequest: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        Column(
            modifier
                .padding(dialogPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Inventaire",
                style = MaterialTheme.typography.headlineMedium
            )
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 100.dp)
            ) {
                items(
                    items
                ) { item ->
                    InventoryBox(item = item.resource, showItem = showItem)
                }
            }
        }
    }
}

@Composable
private fun InventoryBox(
    item: Int,
    showItem: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .padding(itemDialogPadding)
            .clip(shape = RoundedCornerShape(25))
            .border(border = BorderStroke(2.dp, Color.Black), shape = RoundedCornerShape(25))
            .background(InventoryBoxColor)
            .clickable { showItem(item) }
            .wrapContentSize(Alignment.Center)
            .padding(dialogPadding)
    ) {
        Image(
            painter = painterResource(
                id = item
            ),
            contentDescription = "Item in inventory"
        )
    }
}

@ScreenPreview
@Composable
fun InventoryDialogPreview() {
    ZEscapeThemePreview {
        InventoryDialog(
            Modifier,
            items = listOf(ItemDto("paper", R.mipmap.paper)),
            showItem = {},
            onDismissRequest = {}
        )
    }
}
