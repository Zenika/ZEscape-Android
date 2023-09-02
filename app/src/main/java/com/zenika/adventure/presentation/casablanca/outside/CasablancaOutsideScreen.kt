package com.zenika.adventure.presentation.casablanca.outside

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.adventure.presentation.component.AdventureInventoryBag
import com.zenika.adventure.presentation.component.ContinentsMap
import com.zenika.adventure.presentation.component.ScaffoldScreen
import com.zenika.data.AdventureHint
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun CasablancaOutsideScreen(
    remainingTime: Int,
    newItem: Boolean,
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    openHintValidation: (AdventureHint) -> Unit,
    enterInAgency: () -> Unit,
    applyPenalty: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    ScaffoldScreen(
        modifier = modifier,
        remainingTime = remainingTime,
        goToSettings = goToSettings,
        openHintValidation = { openHintValidation(AdventureHint.CASABLANCA_OUTSIDE_HINT) },
        background = R.mipmap.casablanca_outside
    ) {
        CasablancaOutsideContent(
            enterInAgency = enterInAgency,
            applyPenalty = applyPenalty
        )
        ContinentsMap(
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomStart)
                .clickable(onClick = openWorldMap)
        )
        AdventureInventoryBag(
            newItem = newItem,
            openInventory = openInventory,
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@Composable
private fun CasablancaOutsideContent(
    enterInAgency: () -> Unit,
    applyPenalty: (String) -> Unit
) {
    val buttonTexts = listOf(
        R.string.force_door,
        R.string.ring_intercom,
        R.string.go_through_window,
        R.string.sleep_hotel
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally)
    ) {
        item(span = { GridItemSpan(2) }) {
            Text(
                text = stringResource(R.string.casablanca_outside_text),
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
        items(buttonTexts) { buttonText ->
            Button(
                onClick = {
                    when (buttonText) {
                        R.string.go_through_window -> enterInAgency()
                        R.string.force_door -> applyPenalty("door")
                        R.string.ring_intercom -> applyPenalty("intercom")
                        R.string.sleep_hotel -> applyPenalty("hotel")
                    }
                },
                modifier = Modifier.height(80.dp)
            ) {
                Text(
                    text = stringResource(buttonText),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@ScreenPreview
@Composable
private fun CasablancaOutsideScreenPreview() {
    ZEscapeThemePreview {
        CasablancaOutsideScreen(
            remainingTime = 0,
            newItem = false,
            goToSettings = {},
            openWorldMap = {},
            openInventory = {},
            openHintValidation = {},
            enterInAgency = {},
            applyPenalty = {}
        )
    }
}
