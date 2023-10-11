package com.zenika.story.adventure.presentation.inventory

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
import com.zenika.data.entity.ItemEntity
import com.zenika.data.state.InventoryState
import com.zenika.story.adventure.presentation.component.AdventureDialog
import com.zenika.story.adventure.presentation.inventory.component.AdventureInventoryBox
import com.zenika.theme.ScreenPreview
import com.zenika.theme.ZEscapeThemePreview

@Composable
fun AdventureInventoryDialog(
    inventory: InventoryState,
    onItemClick: (Int) -> Unit,
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
                    inventory.items
                ) { item ->
                    AdventureInventoryBox(item = item.resource, onItemClick = onItemClick)
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
            inventory = InventoryState(
                listOf(
                    ItemEntity("hook", R.mipmap.hook),
                    ItemEntity("singaporeKey", R.mipmap.singapore_key),
                    ItemEntity("sword", R.mipmap.sword),
                    ItemEntity("", 0),
                    ItemEntity("", 0),
                    ItemEntity("", 0),
                    ItemEntity("", 0),
                    ItemEntity("", 0),
                    ItemEntity("", 0),
                    ItemEntity("", 0)
                )
            ),
            onItemClick = {},
            onDismissRequest = {}
        )
    }
}
