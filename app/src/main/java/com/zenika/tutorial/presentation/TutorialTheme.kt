package com.zenika.tutorial.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.zenika.R
import com.zenika.ui.theme.LocalZEscapeTypography
import com.zenika.ui.theme.ZEscapeTypography


@Composable
fun TutorialTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalZEscapeTypography provides ZEscapeTypography(
            body = TextStyle(
                fontFamily = FontFamily(Font(R.font.note_this)),
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                lineHeight = 28.sp,
                letterSpacing = 0.5.sp,
            ),
            shoutOut = TextStyle(
                fontFamily = FontFamily(Font(R.font.note_this)),
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                lineHeight = 32.sp,
                letterSpacing = 0.5.sp
            )
        ),
        content = content
    )
}