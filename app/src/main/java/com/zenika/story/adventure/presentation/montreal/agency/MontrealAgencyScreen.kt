package com.zenika.story.adventure.presentation.montreal.agency

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.story.adventure.domain.model.AdventureHint
import com.zenika.story.adventure.presentation.component.AdventureInventoryBag
import com.zenika.story.adventure.presentation.component.ContinentsMap
import com.zenika.story.adventure.presentation.component.ScaffoldScreen
import com.zenika.theme.ScreenPreview
import com.zenika.theme.ZEscapeThemePreview

@Composable
fun MontrealAgencyScreen(
    remainingTime: Int,
    newItem: Boolean,
    isRooftopDiscovered: Boolean,
    isOfficeDiscovered: Boolean,
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    goToScan: (String) -> Unit,
    openHintValidation: (AdventureHint) -> Unit,
    modifier: Modifier = Modifier
) {
    ScaffoldScreen(
        remainingTime = remainingTime,
        goToSettings = goToSettings,
        openHintValidation = { openHintValidation(AdventureHint.MONTREAL_AGENCY_HINT) },
        background = R.mipmap.montreal_agency,
        modifier = modifier
    ) {
        MontrealAgencyMap(
            isRooftopDiscovered,
            isOfficeDiscovered,
            goToScan
        )
        ContinentsMap(
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomStart)
                .clickable(onClick = openWorldMap)
        )
        AdventureInventoryBag(
            openInventory = openInventory,
            newItem = newItem,
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@ScreenPreview
@Composable
private fun MontrealAgencyScreenPreview() {
    ZEscapeThemePreview {
        MontrealAgencyScreen(
            remainingTime = 0,
            newItem = false,
            isRooftopDiscovered = false,
            isOfficeDiscovered = false,
            goToSettings = {},
            openWorldMap = {},
            openInventory = {},
            goToScan = {},
            openHintValidation = {}
        )
    }
}
