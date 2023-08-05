package com.zenika.presentation.debug

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.data.Game
import com.zenika.presentation.component.ReturnButton
import com.zenika.presentation.debug.component.MiniGameCard
import com.zenika.ui.theme.screenPadding
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DebugScreen(
    goBack: () -> Unit,
    initGameState: () -> Unit,
    games: ImmutableList<Pair<Game, () -> Unit>>,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.debug),
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = {
                    ReturnButton(goBack)
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(screenPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            state = rememberLazyListState()
        ) {
            item {
                Button(onClick = initGameState) {
                    Text(
                        text = stringResource(R.string.init_game),
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
            items(items = games) { item ->
                MiniGameCard(
                    game = item.first,
                    onClick = item.second
                )
            }
        }
    }
}

@ScreenPreview
@Composable
private fun DebugScreenPreview() {
    ZEscapeThemePreview {
        DebugScreen(
            goBack = {},
            initGameState = {},
            games = persistentListOf(
                Game.ON_OFF to {},
                Game.ON_OFF to {}
            )
        )
    }
}
