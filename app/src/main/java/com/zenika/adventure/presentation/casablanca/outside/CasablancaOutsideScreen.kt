package com.zenika.adventure.presentation.casablanca.outside

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.adventure.presentation.component.AdventureInventoryBag
import com.zenika.adventure.presentation.component.ContinentsMap
import com.zenika.adventure.presentation.component.ScaffoldScreen
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun CasablancaOutsideScreen(
    remainingTime: Int,
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    enterInAgency: () -> Unit
) {
    val buttonsText = listOf(
        R.string.force_door,
        R.string.ring_intercom,
        R.string.go_through_window,
        R.string.sleep_hotel
    )

    ScaffoldScreen(
        remainingTime = remainingTime,
        goToSettings = goToSettings,
        background = R.mipmap.casablanca_outside
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally)
        ) {
            items(
                buttonsText.size
            ) { item ->
                Button(
                    onClick = { if (buttonsText[item] == R.string.go_through_window) enterInAgency() },
                    modifier = Modifier.height(80.dp)
                ) {
                    Text(
                        text = stringResource(buttonsText[item]),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        ContinentsMap(
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomStart)
                .clickable { openWorldMap() }
        )
        AdventureInventoryBag(
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomEnd)
                .clickable { openInventory() }
        )
    }
}

@ScreenPreview
@Composable
private fun CasablancaOutsideScreenPreview() {
    ZEscapeThemePreview {
        CasablancaOutsideScreen(
            remainingTime = 60,
            goToSettings = {},
            openWorldMap = {},
            openInventory = {},
            enterInAgency = {}
        )
    }
}