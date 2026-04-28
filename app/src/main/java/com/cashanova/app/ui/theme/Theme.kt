package com.cashanova.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val CashanovaDarkColors = darkColorScheme(
    primary = Gold,
    onPrimary = Black,
    secondary = GoldDark,
    background = Black,
    onBackground = TextWhite,
    surface = BlackCard,
    onSurface = TextWhite,
    error = ErrorRed,
    outline = Gold
)

@Composable
fun CashanovaTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = CashanovaDarkColors,
        typography = Typography,
        content = content
    )
}

