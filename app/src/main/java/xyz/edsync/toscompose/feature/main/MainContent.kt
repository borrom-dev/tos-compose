package xyz.edsync.toscompose.feature.main

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.edsync.common.util.extension.openUrl
import xyz.edsync.common.util.listener.ItemClickListener
import xyz.edsync.common.util.ui.DefaultText
import xyz.edsync.toscompose.R
import xyz.edsync.toscompose.theme.Orange
import xyz.edsync.toscompose.theme.Teal200
import xyz.edsync.toscompose.theme.TosComposeTheme

@Composable
fun MainContent(listener: ItemClickListener<Int>) {
    TosComposeTheme {
        val context: Context = LocalContext.current
        Scaffold(modifier = Modifier.fillMaxSize(), topBar = { TopBar() }, floatingActionButton = {
            FloatingButton { context.openUrl("https://github.com/borrom-dev/tos-compose") }
        }) {
            Body(menus = Menu.getItems(), listener = listener)
        }
    }
}

@Composable
fun TopBar() {
    TopAppBar(title = {
        DefaultText(
            text = stringResource(id = R.string.app_name), fontSize = 20.sp, style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
            )
        )
    },
        modifier = Modifier.fillMaxWidth(),
        elevation = 0.dp,
        backgroundColor = Teal200,
        actions = {

        })
}

@Composable
fun FloatingButton(onFloatingActionClick: () -> Unit) {
    FloatingActionButton(onClick = onFloatingActionClick) {
        Image(
            modifier = Modifier.size(46.dp),
            painter = painterResource(id = R.drawable.ic_github),
            contentDescription = "GitHub"
        )
        Spacer(modifier = Modifier.size(16.dp))
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Body(menus: MutableList<Menu>, listener: ItemClickListener<Int>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        menus.forEach { item ->
            stickyHeader { Header(title = item.title) }
            itemsIndexed(item.sampleNames) { index: Int, sampleName: Int ->
                BodyItem(
                    sampleName = sampleName,
                    isLastItem = index == item.sampleNames.size - 1,
                    listener
                )
            }
        }
    }
}

@Composable
fun Header(@StringRes title: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
    ) {
        DefaultText(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
            text = stringResource(id = title),
            fontSize = 14.sp,
            style = TextStyle(color = Color.Black)
        )
    }
}

@Composable
fun BodyItem(
    @StringRes sampleName: Int, isLastItem: Boolean = false, listener: ItemClickListener<Int>
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



@Preview(showBackground = true)
@Composable
fun MainContentPreview() {
    TosComposeTheme {
        MainContent(listener = object : ItemClickListener<Int> {
            override fun onItemClicked(item: Int) {
                // no implementation
            }
        })
    }
}

