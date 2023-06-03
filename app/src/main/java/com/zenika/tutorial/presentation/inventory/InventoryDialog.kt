package com.zenika.tutorial.presentation.inventory

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.zenika.R
import com.zenika.data.model.ItemDto
import com.zenika.data.state.InventoryState
import com.zenika.tutorial.presentation.inventory.component.InventoryBox
import com.zenika.ui.theme.dialogPadding
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun InventoryDialog(
    modifier: Modifier,
    items: InventoryState,
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
                Modifier.padding(dialogPadding),
                style = MaterialTheme.typography.headlineMedium
            )
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 100.dp),
            ) {
                items(
                    items.items
                ) { item ->
                    InventoryBox(item = item.resource, showItem = showItem)
                }
            }
        }
    }
}

@ScreenPreview
@Composable
fun InventoryDialogPreview() {
    ZEscapeThemePreview {
        InventoryDialog(
            Modifier,
            items = InventoryState(
                listOf(
                    ItemDto("paper", R.mipmap.paper),
                    ItemDto("paper", R.mipmap.paper),
                    ItemDto("paper", R.mipmap.paper),
                    ItemDto("paper", R.mipmap.paper),
                    ItemDto("", 0),
                    ItemDto("", 0)
                )
            ),
            showItem = {}
        ) {}
    }
}
