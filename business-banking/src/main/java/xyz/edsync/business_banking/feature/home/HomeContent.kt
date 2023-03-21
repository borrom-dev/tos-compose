package xyz.edsync.business_banking.feature.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import xyz.edsync.business_banking.R
import xyz.edsync.business_banking.feature.expense.ExpenseContent
import xyz.edsync.business_banking.model.TabInfo
import xyz.edsync.business_banking.ui.theme.ColorPrimary
import xyz.edsync.business_banking.ui.theme.ColorSecondaryText
import xyz.edsync.common.util.ui.DefaultText
import xyz.edsync.toscompose.theme.TosComposeTheme

@OptIn(ExperimentalPagerApi::class)
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
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            HorizontalPager(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1F)
                                    .height(0.dp),
                                count = tabs.size
                            ) {
                                ExpenseContent()
                            }
                            Box {
                                TabRow(
                                    modifier = Modifier.align(Alignment.Center),
                                    selectedTabIndex = tabState,
                                    backgroundColor = Color.White
                                ) {
                                    tabs.forEachIndexed { index, tabInfo ->
                                        Tab(selected = tabState == index, onClick = {
                                            tabState = index
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
                        }
                        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
                            Box(
                                modifier = Modifier
                                    .size(56.dp)
                                    .clip(CircleShape)
                                    .background(color = Color.White)
                            )
                            Spacer(modifier = Modifier.size(16.dp))
                        }
                        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
                            Box(
                                modifier = Modifier
                                    .size(48.dp)
                                    .clip(CircleShape)
                                    .background(color = ColorPrimary)
                            ) {
                                Image(
                                    modifier = Modifier.align(Alignment.Center),
                                    painter = painterResource(id = R.drawable.ic_plus),
                                    contentDescription = "Plus Icon"
                                )
                            }
                            Spacer(modifier = Modifier.size(20.dp))
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
