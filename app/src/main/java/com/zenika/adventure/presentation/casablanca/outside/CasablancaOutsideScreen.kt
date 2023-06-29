package com.zenika.adventure.presentation.casablanca.outside

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.adventure.presentation.component.ScaffoldScreen
import com.zenika.ui.theme.screenPadding
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
        "Forcer la porte d'entrée",
        "Sonner à l'interphone",
        "Passer par la fenêtre",
        "Dormir à l'hôtel"
    )

    ScaffoldScreen(
        remainingTime = remainingTime,
        goToSettings = goToSettings,
        onClick = enterInAgency,
        openWorldMap = openWorldMap,
        openInventory = openInventory,
        background = R.mipmap.casablanca_outside
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(screenPadding),
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally)
        ) {
            items(
                buttonsText.size
            ) { item ->
                Button(onClick = enterInAgency,
                    modifier = Modifier.height(80.dp)) {
                    Text(
                        text = buttonsText[item],
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@ScreenPreview
@Composable
fun CasablancaOutsideScreenPreview() {
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