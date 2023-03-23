package xyz.edsync.common.util.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import xyz.edsync.common.util.theme.Orange

@Composable
fun Hexagon(title: String, height: Dp = 200.dp, color: Color = Orange) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = height)
            .clip(shape = HexagonShape())
            .background(color = color),
        contentAlignment = Alignment.Center
    ) {
        Text(text = title)
    }
}

