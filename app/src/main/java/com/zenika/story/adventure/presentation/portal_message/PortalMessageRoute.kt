package com.zenika.story.adventure.presentation.portal_message

import androidx.compose.runtime.Composable

@Composable
fun PortalMessageRoute(
    onDismissRequest: () -> Unit
) {
    PortalMessageDialog(
        onDismissRequest
    )
}
