package xyz.edsync.business_banking.feature.home.wallet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import xyz.edsync.business_banking.R
import xyz.edsync.business_banking.ui.theme.*
import xyz.edsync.common.util.ui.DefaultText

@Composable
fun WalletContent() {
    BusinessBankingTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = { TopBar() },
                backgroundColor = ColorBackground
            ) {
                Content()
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun Content() {
    val pagerState = rememberPagerState(0)
    val currentPage by remember {
        mutableStateOf(0)
    }
    val items = arrayOf(
        stringResource(id = R.string.text_day),
        stringResource(id = R.string.text_week),
        stringResource(id = R.string.text_month),
        stringResource(id = R.string.text_year)
    )
    LazyColumn {
        item {
            SendMoneyToContent()
            Spacer(modifier = Modifier.size(16.dp))
            DefaultText(
                text = stringResource(id = R.string.title_transactions),
                fontSize = 20.sp,
                style = TextStyle(color = ColorDarkPrimary, fontWeight = FontWeight.SemiBold)
            )
            Spacer(modifier = Modifier.size(8.dp))
            TransactionFilterHeader(currentPage, items)
        }
        items(5) {
            TransactionItem()
        }
    }
}

@Composable
private fun SendMoneyToContent() {
    DefaultText(
        modifier = Modifier.padding(horizontal = 16.dp),
        text = stringResource(id = R.string.title_send_money_to),
        fontSize = 20.sp,
        style = TextStyle(color = ColorDarkPrimary, fontWeight = FontWeight.SemiBold)
    )
    Spacer(modifier = Modifier.size(8.dp))
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(count = 5) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.size(16.dp))
                Card(
                    modifier = Modifier
                        .width(90.dp)
                        .height(110.dp),
                    shape = RoundedCornerShape(12.dp),
                    backgroundColor = Color.White
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_add_new_contract),
                            contentDescription = "Add new contract"
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                        DefaultText(
                            text = "Add new contact",
                            style = TextStyle(
                                color = ColorSecondaryText,
                                fontSize = 13.sp,
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun TransactionItem() {
    Card(
        modifier = Modifier.padding(16.dp),
        backgroundColor = Color.White,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(40.dp),
                painter = painterResource(id = R.drawable.ic_gas),
                contentDescription = "gas"
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // TODO to update string
                Column(horizontalAlignment = Alignment.Start) {
                    DefaultText(text = "Shell", style = TextStyle(color = Color.Black))
                    DefaultText(text = "17 Monday June", style = TextStyle(color = Color.Black))
                }
                DefaultText(text = "-$35,88", style = TextStyle(color = Color.Red))
            }
        }
    }
}

@Composable
private fun TransactionFilterHeader(currentPage: Int, items: Array<String>) {
    var currentPage1 = currentPage
    TabRow(
        selectedTabIndex = currentPage1,
        backgroundColor = Color.Transparent,
        contentColor = ColorSecondaryText,
        divider = { Divider() },
        indicator = {}
    ) {
        items.forEachIndexed { index, text ->
            Tab(modifier = if (index == currentPage1) Modifier
                .padding(4.dp)
                .height(30.dp)
                .background(color = Color(0xFFDFE7F5), shape = RoundedCornerShape(6.dp))
            else Modifier.padding(8.dp),
                selected = currentPage1 == index,
                onClick = {
                    currentPage1 = index
                }) {
                DefaultText(text = text)
            }
        }
    }
    Spacer(modifier = Modifier.padding(top = 8.dp))
}

@Composable
private fun TopBar() {
    TopAppBar(title = {
        DefaultText(
            text = stringResource(id = R.string.text_wallet),
            fontSize = 20.sp,
            style = TextStyle(color = ColorDarkPrimary, fontWeight = FontWeight.SemiBold)
        )
    },
        modifier = Modifier.fillMaxWidth(),
        elevation = 0.dp,
        backgroundColor = Color.Transparent,
        actions = {
            IconButton(onClick = { }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_add_card),
                    contentDescription = "Add Card"
                )
            }
        })
}
