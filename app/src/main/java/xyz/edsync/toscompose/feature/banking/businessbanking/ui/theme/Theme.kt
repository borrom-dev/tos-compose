package xyz.edsync.toscompose.feature.banking.businessbanking.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import xyz.edsync.toscompose.feature.main.ui.theme.Purple700
import xyz.edsync.toscompose.feature.main.ui.theme.Shapes
import xyz.edsync.toscompose.feature.main.ui.theme.Teal200

private val ColorPalette = darkColors(
    primary = ColorPrimary,
    primaryVariant = Purple700,
    secondary = Teal200
)

@Composable
fun BusinessBankingTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = ColorPalette,
        typography = Typography(),
        shapes = Shapes,
        content = content
    )
}