package com.zenika.sample

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zenika.ui.theme.ZEscapeTheme

@Composable
fun ListingRoute() {
    LazyColumn {
        items(Item.values()) { item ->
            Text(
                text = item.label,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(19.dp)
            )
        }
    }
}

enum class Item(
    val label: String
) {
    ColorButtonsOrderGame("Color Buttons Order Game") {
        @Composable
        override fun Render() {
            TODO("Not yet implemented")
        }
    };

    @Composable
    abstract fun Render()
}

@Preview
@Composable
fun ListingRoutePreview() {
    ZEscapeTheme {
        ListingRoute()
    }
}