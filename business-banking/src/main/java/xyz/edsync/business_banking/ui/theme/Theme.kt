package xyz.edsync.business_banking.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val ColorPalette = darkColors(
    primary = ColorPrimary,
    primaryVariant = Purple700,
    secondary = Teal200
)

@Composable
fun BusinessBankingTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = ColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}