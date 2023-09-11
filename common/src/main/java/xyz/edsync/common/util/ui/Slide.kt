package xyz.edsync.common.util.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@ExperimentalFoundationApi
@Composable
fun ImageSlider(
    modifier: Modifier = Modifier,
    autoSlideDuration: Long = 6000L,
    itemsCount: Int
) {
    val positionFromIWantToStart = 3
    val numPages = Int.MAX_VALUE / itemsCount
    val startPage = numPages / 2
    val startIndex = (startPage * itemsCount) + positionFromIWantToStart

    var currentPage by remember { mutableStateOf(startIndex) }
    val pagerState = rememberPagerState(initialPage = startIndex)
    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()

    LaunchedEffect(pagerState.currentPage) {
        delay(autoSlideDuration)
        pagerState.animateScrollToPage((pagerState.currentPage + 1) % itemsCount)
    }

    Box(
        modifier = modifier.fillMaxWidth(),
    ) {

        HorizontalPager(pageCount = Int.MAX_VALUE, state = pagerState) { index ->
            currentPage = index % itemsCount
            DefaultText(
                text = "$index, ${pagerState.currentPage}",
                modifier = Modifier.size(240.dp)
            )
        }

        // you can remove the surface in case you don't want
        // the transparant bacground
        Surface(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .align(Alignment.BottomCenter),
            shape = CircleShape,
            color = Color.Black.copy(alpha = 0.5f)
        ) {
            DotsIndicator(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                totalDots = itemsCount,
                selectedIndex = if (isDragged) pagerState.currentPage else pagerState.targetPage,
            )
        }
    }
}