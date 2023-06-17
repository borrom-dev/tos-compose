package xyz.edsync.slidetransfom.feature

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.edsync.common.util.listener.ItemClickListener
import xyz.edsync.common.util.model.Menu
import xyz.edsync.common.util.theme.Orange
import xyz.edsync.common.util.ui.DefaultText
import xyz.edsync.slidetransfom.R
import xyz.edsync.slidetransfom.ui.theme.TosComposeTheme

private val menus = Menu(
    title = 0,
    sampleNames = mutableListOf<Int>().apply {
        add(R.string.slide_stack)
    }
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SlideTransformContent(listener: ItemClickListener<Int>) {
    TosComposeTheme {
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                TopBar()
            }, floatingActionButton = {

            }) {
            Body(paddingValues = it, menu = menus, listener = listener)
        }
    }
}

@Composable
private fun TopBar() {
    TopAppBar(title = {
        DefaultText(
            text = "",
            fontSize = 20.sp,
            style = TextStyle(color = Color.Black, fontWeight = FontWeight.SemiBold)
        )
    },
        modifier = Modifier.fillMaxWidth(),
        elevation = 0.dp,
        backgroundColor = Color.Transparent,
        actions = {
        })
}


@Composable
private fun Body(
    paddingValues: PaddingValues,
    menu: Menu,
    listener: ItemClickListener<Int>
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(items = menu.sampleNames) { index, item ->
            BodyItem(
                sampleName = item,
                isLastItem = index == menu.sampleNames.size - 1,
                listener
            )
        }
    }
}

@Composable
private fun BodyItem(
    @StringRes sampleName: Int,
    isLastItem: Boolean = false,
    listener: ItemClickListener<Int>
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Orange)
        .clickable { listener.onItemClicked(sampleName) }) {
        DefaultText(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
            text = stringResource(id = sampleName),
            fontSize = 20.sp,
            style = TextStyle(color = Color.Black)
        )
        if (!isLastItem) {
            Divider(
                Modifier.padding(start = 16.dp), color = Color.Black, thickness = 0.5.dp
            )
        }
    }
}
