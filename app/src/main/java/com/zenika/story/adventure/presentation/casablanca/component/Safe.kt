package com.zenika.story.adventure.presentation.casablanca.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.theme.ComposablePreview
import com.zenika.theme.ZEscapeThemePreview

@Composable
fun Safe(
    isSafeOpened: Boolean,
    isKeyCollected: Boolean,
    goToSafe: () -> Unit,
    collectKey: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (!isSafeOpened) {
        SafeItem(R.mipmap.close_safe, onClick = goToSafe, modifier)
    } else if (!isKeyCollected) {
        SafeItem(R.mipmap.key_safe, onClick = collectKey, modifier)
    } else {
        SafeItem(R.mipmap.open_safe, onClick = {}, modifier)
    }
}

@Composable
private fun SafeItem(
    @DrawableRes
    safeDrawable: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val closeSafeState = stringResource(R.string.close_safe)
    val keySafeState = stringResource(R.string.open_map_treasure_chest)
    val openSafeState = stringResource(R.string.open_safe)

    Image(
        painter = painterResource(safeDrawable),
        contentDescription = stringResource(R.string.safe),
        contentScale = ContentScale.Fit,
        modifier = modifier
            .size(200.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            )
            .semantics {
                stateDescription =
                    when (safeDrawable) {
                        R.mipmap.close_safe -> closeSafeState
                        R.mipmap.key_safe -> keySafeState
                        else -> openSafeState
                    }
            }
    )
}

@ComposablePreview
@Composable
fun SafePreview() {
    ZEscapeThemePreview {
        Safe(
            isSafeOpened = true,
            isKeyCollected = false,
            goToSafe = {},
            collectKey = {}
        )
    }
}
