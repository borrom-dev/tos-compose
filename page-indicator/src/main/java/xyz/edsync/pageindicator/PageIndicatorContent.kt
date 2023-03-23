package xyz.edsync.pageindicator

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import xyz.edsync.common.util.ui.Hexagon

@Composable
internal fun PageIndicatorContent() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        LazyColumn(content = {
            items(10) {
                Hexagon(title = "Test $it")
            }
        })
    }

}
