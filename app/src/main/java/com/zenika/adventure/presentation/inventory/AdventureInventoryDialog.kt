package com.zenika.adventure.presentation.inventory

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.zenika.adventure.presentation.inventory.component.AdventureInventoryBox
import com.zenika.data.model.ItemDto
import com.zenika.data.state.InventoryState
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun AdventureInventoryDialog(
    items: InventoryState,
    showItem: (Int) -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    AdventureDialog(
        onDismissRequest = onDismissRequest
    ) {
        Column(
            modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.inventory),
                Modifier.padding(bottom = 12.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                items(
                    items.items
                ) { item ->
                    AdventureInventoryBox(item = item.resource, showItem = showItem)
                }
            }
        }
    }
}

@ScreenPreview
@Composable
private fun AdventureInventoryDialogPreview() {
    ZEscapeThemePreview {
        AdventureInventoryDialog(
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
            showItem = {},
            onDismissRequest = {}
        )
    }
}
