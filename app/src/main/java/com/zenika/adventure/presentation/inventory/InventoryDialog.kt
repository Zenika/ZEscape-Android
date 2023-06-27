package com.zenika.adventure.presentation.inventory

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.adventure.presentation.component.AdventureDialog
import com.zenika.adventure.presentation.inventory.component.InventoryBox
import com.zenika.data.model.ItemDto
import com.zenika.data.state.InventoryState
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
    AdventureDialog(
        onDismissRequest = onDismissRequest
    ) {
        Column(
            modifier
                .height(580.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.inventory),
                Modifier.padding(dialogPadding),
                style = MaterialTheme.typography.headlineMedium
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
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
                    ItemDto("hook", R.mipmap.hook),
                    ItemDto("singaporeKey", R.mipmap.singapore_key),
                    ItemDto("sword", R.mipmap.sword),
                    ItemDto("", 0),
                    ItemDto("", 0),
                    ItemDto("", 0),
                    ItemDto("", 0),
                    ItemDto("", 0),
                    ItemDto("", 0),
                    ItemDto("", 0)
                )
            ),
            showItem = {}
        ) {}
    }
}
