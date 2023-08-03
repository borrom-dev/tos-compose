package xyz.edsync.common.util.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun TosComposeTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        shapes = Shapes,
        content = content
    )
}