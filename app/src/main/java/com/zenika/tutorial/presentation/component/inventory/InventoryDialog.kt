package com.zenika.tutorial.presentation.component.inventory

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.zenika.tutorial.domain.InventoryViewModel
import com.zenika.ui.theme.InventoryBoxColor
import com.zenika.ui.theme.dialogPadding
import com.zenika.ui.theme.itemDialogPadding
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun InventoryDialog(
    viewModel: InventoryViewModel = hiltViewModel(),
    onDismissRequest: () -> Unit,
    showItem: (Int) -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        InventoryContent(
            viewModel,
            Modifier
                .fillMaxWidth()
                .background(
                    MaterialTheme.colorScheme.primaryContainer,
                    MaterialTheme.shapes.extraLarge
                ),
            showItem
        )
    }
}

@Composable
private fun InventoryContent(
    viewModel: InventoryViewModel,
    modifier: Modifier,
    showItem: (Int) -> Unit
) {
    val items by viewModel.inventoryItems.collectAsState()
    Log.d("items", items.toString())
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
                items.values.toList()
            ) { item ->
                InventoryBox(item = item, showItem = showItem)
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
        InventoryContent(
            viewModel = InventoryViewModel(),
            Modifier,
            showItem = {}
        )
    }
}
