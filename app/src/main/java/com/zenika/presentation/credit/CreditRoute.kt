package com.zenika.presentation.credit

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CreditRoute(
    goBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    CreditScreen(
        goBack = goBack,
        modifier = modifier
    )
}
