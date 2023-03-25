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
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import xyz.edsync.business_banking.R
import xyz.edsync.business_banking.feature.expense.ExpenseContent
import xyz.edsync.business_banking.feature.home.model.enums.HomeTab
import xyz.edsync.business_banking.feature.yourbudget.YourBudgetContent
import xyz.edsync.business_banking.model.TabInfo
import xyz.edsync.business_banking.ui.theme.ColorPrimary
import xyz.edsync.business_banking.ui.theme.ColorSecondaryText
import xyz.edsync.common.util.ui.DefaultText
import xyz.edsync.toscompose.theme.TosComposeTheme

@Composable
internal fun HomeContent() {
    TosComposeTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Body()
        }
    }
}

@Composable
@OptIn(ExperimentalPagerApi::class)
private fun Body() {
    val tabs = mutableListOf(
        TabInfo(R.string.text_home, R.drawable.ic_banking_home),
        TabInfo(R.string.text_expenses, R.drawable.ic_banking_expenses),
        TabInfo(-1, -1),
        TabInfo(R.string.text_wallet, R.drawable.ic_banking_wallet),
        TabInfo(R.string.text_profile, R.drawable.ic_banking_profile)
    )
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
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
                        count = 4,
                        state = pagerState,
                    ) { position ->
                        HorizontalContents(position = position)
                    }
                    TabContent(coroutineScope, pagerState, tabs)
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

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun TabContent(
    coroutineScope: CoroutineScope,
    pagerState: PagerState,
    tabs: MutableList<TabInfo>
) {
    val selectedTabIndex = when (pagerState.currentPage) {
        2 -> HomeTab.WALLET.rawValue
        3 -> HomeTab.PROFILE.rawValue
        else -> pagerState.currentPage
    }
    Box {
        TabRow(
            modifier = Modifier.align(Alignment.Center),
            selectedTabIndex = selectedTabIndex,
            backgroundColor = Color.White
        ) {
            tabs.forEachIndexed { index, tabInfo ->
                Tab(selected = selectedTabIndex == index, onClick = {
                    val clickedIndex = when (index) {
                        HomeTab.WALLET.rawValue, HomeTab.PROFILE.rawValue -> index - 1
                        else -> index
                    }
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(clickedIndex)
                    }
                }) {
                    if (tabInfo.iconRes != -1) {
                        TabItem(
                            IconRes = tabInfo.iconRes,
                            titleRes = tabInfo.titleRes,
                            selectedTabIndex == index
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun HorizontalContents(position: Int) {
    when (position) {
        HomeTab.HOME.rawValue -> YourBudgetContent()
        HomeTab.EXPENSES.rawValue -> ExpenseContent()
        HomeTab.WALLET.rawValue -> YourBudgetContent()
        HomeTab.PROFILE.rawValue -> ExpenseContent()
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
