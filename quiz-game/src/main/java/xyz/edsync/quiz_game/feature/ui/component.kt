package xyz.edsync.quiz_game.feature.ui

import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter

@Composable
fun SmallButton(
    modifier: Modifier = Modifier,
    painter: Painter,
    onClick: () -> Unit
) {

    Button(
        modifier = modifier,
        onClick = onClick,
    ) {
        Image(painter = painter, contentDescription = "ButtonImage")
    }

}