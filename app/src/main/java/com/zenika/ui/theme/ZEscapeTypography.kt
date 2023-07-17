package com.zenika.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.zenika.R

class ZEscapeTypography(
    val body: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.teko_light)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.5.sp,
    ),
    val shoutOut: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.teko_light)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.5.sp
    )
)

val LocalZEscapeTypography = staticCompositionLocalOf { ZEscapeTypography() }
