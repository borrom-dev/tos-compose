package xyz.edsync.common.util.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun DotsIndicator(
    modifier: Modifier = Modifier,
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color = Color(0xFF042C5C),
    unSelectedColor: Color = Color(0xFF77869E),
    dotModifier: Modifier = Modifier,
    dotShape: Shape = CircleShape
) {
    LazyRow(
        modifier = modifier
            .wrapContentWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        items(totalDots) { index ->
            var size = 6.dp
            var color = unSelectedColor
            if (index == selectedIndex) {
                size = 10.dp
                color = selectedColor
            }
            Box(
                modifier = dotModifier
                    .size(size)
                    .clip(dotShape)
                    .background(color)
            )
            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            }
        }
    }
}