package xyz.edsync.background

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.DrawModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope


fun Modifier.aniBackground() = this.then(
    AniBackground()
)

class AniBackground : DrawModifier {

    override fun ContentDrawScope.draw() {
        drawCircle(Color.Red)
        drawContent()
    }
}