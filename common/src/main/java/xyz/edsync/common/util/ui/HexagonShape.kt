package xyz.edsync.common.util.ui

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import java.lang.Float.min

class HexagonShape : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = drawCustomHexagonPath(size)
        )
    }
}

fun drawCustomHexagonPath(size: Size): Path {
    return Path().apply {
        val radius = min(size.width / 2f, size.height / 2f)
        customHexagon(radius, size)
    }
}

fun Path.customHexagon(radius: Float, size: Size) {
    val triangleHeight = (kotlin.math.sqrt(3.0) * radius / 2)
    val midx: Float = size.width / 2
    val midy: Float = size.height / 2

    moveTo(midx, midy)
    lineTo(midx + 150, midy + 220)
    lineTo(midx, midy + 220)
    lineTo(midx - 150, midy + 220)
    lineTo(midx - 300, midy)
    lineTo(midx - 150, midy - 220)
    lineTo(midx + 150, midy - 220)
    lineTo(midx + 300, midy)
    lineTo(midx + 150, midy + 220)

    close()
}