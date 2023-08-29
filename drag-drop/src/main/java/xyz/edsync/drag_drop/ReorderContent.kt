package xyz.edsync.drag_drop

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import org.burnoutcrew.reorderable.ReorderableItem
import org.burnoutcrew.reorderable.detectReorderAfterLongPress
import org.burnoutcrew.reorderable.rememberReorderableLazyListState
import org.burnoutcrew.reorderable.reorderable
import xyz.edsync.common.util.theme.TosComposeTheme
import xyz.edsync.common.util.ui.DefaultText

@Composable
fun ReorderContent() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (colTop, colBottom) = createRefs()
        val moved = remember { mutableStateOf(false) }
        val x = remember { mutableStateOf(0) }
        val offset by animateIntOffsetAsState(
            targetValue = if (moved.value) {
                IntOffset(0, x.value)
            } else {
                IntOffset.Zero
            },
            label = "offset",
            finishedListener = {

            }
        )
        val colors = mutableListOf(Color.Red, Color.Gray, Color.Green)
        val items = mutableListOf("Item 1", "Item 2", "Item 3")

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(ref = colBottom) {
                    top.linkTo(colTop.bottom, margin = 100.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .onGloballyPositioned {
                    x.value = 0
                    x.value = it.positionInRoot().y.toInt()
                },
        ) {
            items.forEachIndexed { index, text ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = colors[index])
                        .clickable { moved.value = !moved.value }
                        .onGloballyPositioned {
                            if (index == 1) {
                                x.value += (it.positionInParent().y.toInt() - 100.dp.value.toInt())
                            }
                        }
                ) {
                    DefaultText(
                        text = text,
                        modifier = Modifier
                            .padding(vertical = 46.dp)
                    )
                }
            }
        }

        Box(modifier = Modifier.constrainAs(ref = colTop) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }) {
            if (moved.value) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    items.forEachIndexed { index, text ->
                        Box(
                            modifier = Modifier.offset {
                                if (index == 1) {
                                    offset
                                } else {
                                    IntOffset.Zero
                                }
                            }
                        ) {
                            Row(
                                Modifier
                                    .background(color = colors[index])
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Spacer(modifier = Modifier.size(16.dp))
                                Image(
                                    painter = painterResource(id = xyz.edsync.common.R.drawable.ic_arrow_down_circle),
                                    contentDescription = ""
                                )
                                Spacer(modifier = Modifier.size(16.dp))
                                DefaultText(
                                    text = text,
                                    modifier = Modifier
                                        .padding(vertical = 8.dp)
                                )
                            }
                        }
                    }
                }
            }

            val data = remember { mutableStateOf(items) }
            val state = rememberReorderableLazyListState(onMove = { from, to ->
                data.value = data.value.toMutableList().apply {
                    add(to.index, removeAt(from.index))
                }
            })

            LazyColumn(
                state = state.listState,
                modifier = Modifier
                    .fillMaxWidth()
                    .reorderable(state)
                    .detectReorderAfterLongPress(state)
            ) {
                items(data.value, key = { it }) {
                    ReorderableItem(state, key = it) { isDragging ->
                        val elevation = animateDpAsState(if (isDragging) 16.dp else 0.dp)
                        Box(
                            modifier = Modifier.offset {
                                if (data.value.indexOf(it) == 1) {
                                    offset
                                } else {
                                    IntOffset.Zero
                                }
                            }
                        ) {
                            Row(
                                Modifier
                                    .background(color = colors[data.value.indexOf(it)])
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Spacer(modifier = Modifier.size(16.dp))
                                Image(
                                    painter = painterResource(id = xyz.edsync.common.R.drawable.ic_arrow_down_circle),
                                    contentDescription = ""
                                )
                                Spacer(modifier = Modifier.size(16.dp))
                                DefaultText(
                                    text = it,
                                    modifier = Modifier
                                        .padding(vertical = 8.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun Preview() {
    TosComposeTheme {
        ReorderContent()
    }
}
