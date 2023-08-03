package xyz.edsync.business_banking.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun BusinessBankingTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        shapes = Shapes,
        content = content
    )
}