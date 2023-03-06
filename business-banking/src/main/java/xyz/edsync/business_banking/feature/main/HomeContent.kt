package xyz.edsync.business_banking.feature.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.edsync.business_banking.R
import xyz.edsync.business_banking.model.TabInfo
import xyz.edsync.business_banking.ui.theme.ColorPrimary
import xyz.edsync.business_banking.ui.theme.ColorSecondaryText
import xyz.edsync.common.util.ui.DefaultText
import xyz.edsync.toscompose.theme.TosComposeTheme

@Composable
fun HomeContent() {
    val tabs = mutableListOf(
        TabInfo(R.string.text_home, R.drawable.ic_banking_home),
        TabInfo(R.string.text_expenses, R.drawable.ic_banking_expenses),
        TabInfo(-1, -1),
        TabInfo(R.string.text_wallet, R.drawable.ic_banking_wallet),
        TabInfo(R.string.text_profile, R.drawable.ic_banking_profile)
    )
    var tabState by remember { mutableStateOf(0) }
    TosComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .background(color = Color.White)
                )
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    backgroundColor = Color.White,
                    shape = RoundedCornerShape(0.dp),
                    elevation = 8.dp
                ) {
                    Box {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.BottomCenter)
                        ) {
                            TabRow(selectedTabIndex = tabState, backgroundColor = Color.White) {
                                tabs.forEachIndexed { index, tabInfo ->
                                    Tab(selected = tabState == index, onClick = {
                                    }) {
                                        if (tabInfo.iconRes != -1) {
                                            TabItem(
                                                IconRes = tabInfo.iconRes,
                                                titleRes = tabInfo.titleRes,
                                                tabState == index
                                            )
                                        }
                                    }
                                }
                            }
                        }
                        FloatingActionButton(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(bottom = 16.dp),
                            onClick = { },
                            backgroundColor = ColorPrimary
                        ) {
                            DefaultText(text = "+")
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TabItem(
    @DrawableRes IconRes: Int,
    @StringRes titleRes: Int,
    isSelected: Boolean = false
) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val title = stringResource(id = titleRes)
        val color = if (isSelected) ColorPrimary else ColorSecondaryText
        Icon(
            painter = painterResource(id = IconRes),
            contentDescription = title,
            tint = color
        )
        DefaultText(
            text = stringResource(id = titleRes),
            style = TextStyle(color = color)
        )
    }
}

@Composable
private fun CustomArcShape(
    modifier: Modifier,
    elevation: Dp = 4.dp,
    color: Color = ColorPrimary,
    contentColor: Color = contentColorFor(color),
    content: @Composable () -> Unit
) {

    val diameter = 60.dp
    val radiusDp = diameter / 2

    val cornerRadiusDp = 10.dp

    val density = LocalDensity.current
    val cutoutRadius = density.run { radiusDp.toPx() }
    val cornerRadius = density.run { cornerRadiusDp.toPx() }

    val shape = remember {
        GenericShape { size: Size, layoutDirection: LayoutDirection ->
//            this.roundedRectanglePath(
//                size = size,
//                cornerRadius = cornerRadius,
//                fabRadius = cutoutRadius * 2
//            )
        }
    }

    Spacer(modifier = Modifier.height(diameter / 2))

    Box(contentAlignment = Alignment.TopCenter) {
        FloatingActionButton(
            shape = CircleShape,
            contentColor = Color(0xffD32F2F),
            modifier = Modifier
                .offset(y = -diameter / 5)
                .size(diameter)
                .drawBehind {
                    drawCircle(
                        Color.Red.copy(.5f),
                        radius = 1.3f * size.width / 2
                    )

                    drawCircle(
                        Color.Red.copy(.3f),
                        radius = 1.5f * size.width / 2
                    )

                }
                .align(Alignment.TopCenter),
            onClick = { /*TODO*/ }
        ) {
            Icon(
                tint = Color.White,
                imageVector = Icons.Filled.Close,
                contentDescription = "Close"
            )
        }

        Surface(
            modifier = modifier,
            shape = shape,
            elevation = elevation,
            color = color,
            contentColor = contentColor
        ) {
            Column {
                Spacer(modifier = Modifier.height(diameter))
                content()

            }
        }
    }
}

@Composable
private fun CustomArcShapeSample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        CustomArcShape(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .height(250.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Payment Failed",
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text("Sorry !", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(10.dp))
                Text("Your transfer to bank failed", color = Color.LightGray)
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        CustomArcShape(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .height(250.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .border(1.dp, Color.Green),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Payment Failed",
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text("Sorry !", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(10.dp))
                Text("Your transfer to bank failed", color = Color.LightGray)
            }
        }

    }
}

@Preview()
@Composable
fun Test() {
    CustomArcShapeSample()
}
