package com.zenika.story.tutorial.presentation.inventory

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
import com.zenika.common.domain.Inventory
import com.zenika.common.data.entity.ItemEntity
import com.zenika.story.tutorial.presentation.component.TutorialDialog
import com.zenika.story.tutorial.presentation.inventory.component.TutorialInventoryBox
import com.zenika.theme.ComposablePreview
import com.zenika.theme.ZEscapeThemePreview
import com.zenika.theme.dialogPadding

@Composable
fun TutorialInventoryDialog(
    modifier: Modifier,
    inventory: Inventory,
    showItem: (Int) -> Unit,
    onDismissRequest: () -> Unit
) {
    TutorialDialog(
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
                modifier = Modifier.padding(dialogPadding),
                style = MaterialTheme.typography.headlineMedium
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
            ) {
                items(
                    inventory.items
                ) { item ->
                    TutorialInventoryBox(item = item.resource, showItem = showItem)
                }
            }
        }
    }
}

@ComposablePreview
@Composable
private fun TutorialInventoryDialogPreview() {
    ZEscapeThemePreview {
        TutorialInventoryDialog(
            Modifier,
            inventory = Inventory(
                listOf(
                    ItemEntity("paper", R.mipmap.paper),
                    ItemEntity("paper", R.mipmap.paper),
                    ItemEntity("paper", R.mipmap.paper),
                    ItemEntity("paper", R.mipmap.paper),
                    ItemEntity("", 0),
                    ItemEntity("", 0),
                    ItemEntity("", 0),
                    ItemEntity("", 0),
                    ItemEntity("", 0),
                    ItemEntity("", 0)
                )
            ),
            showItem = {}
        ) {}
    }
}
