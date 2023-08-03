package xyz.edsync.business_banking.feature.home.yourbudget

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import xyz.edsync.business_banking.R
import xyz.edsync.business_banking.ui.theme.BusinessBankingTheme
import xyz.edsync.business_banking.ui.theme.ColorBackground
import xyz.edsync.business_banking.ui.theme.ColorDarkPrimary
import xyz.edsync.business_banking.ui.theme.ColorPrimary
import xyz.edsync.business_banking.ui.theme.ColorSecondaryText
import xyz.edsync.business_banking.ui.theme.ColorUnselectedDot
import xyz.edsync.business_banking.ui.theme.ColorYourBudgetBackground
import xyz.edsync.business_banking.ui.theme.ColorYourBudgetTitleTopBar
import xyz.edsync.common.util.ui.DefaultText
import xyz.edsync.common.util.ui.DotsIndicator

@Composable
fun YourBudgetContent(modifier: Modifier = Modifier) {
    BusinessBankingTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(modifier = modifier.fillMaxWidth()) {
                BackgroundImage()
                Spacer(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = ColorBackground)
                )
            }
            Scaffold(
                topBar = { TopBar() },
                containerColor = Color.Transparent
            ) {
                Content(it)
            }
        }
    }
}

@Composable
private fun BackgroundImage() {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = ColorBackground),
        painter = painterResource(R.drawable.bg_your_budget),
        contentDescription = "backgroundImage",
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar() {
    TopAppBar(title = {
        DefaultText(
            text = stringResource(id = R.string.title_your_budget),
            fontSize = 20.sp,
            style = TextStyle(
                color = ColorYourBudgetTitleTopBar,
                fontWeight = FontWeight.SemiBold
            )
        )
    },
        modifier = Modifier.fillMaxWidth(),
        actions = {
            IconButton(onClick = { }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_notification),
                    contentDescription = "Notification"
                )
            }
        })
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun Content(paddingValues: PaddingValues) {
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
    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {
        item {
            Column() {
                Spacer(modifier = Modifier.size(8.dp))
                ChartCard(pagerState)
                Spacer(modifier = Modifier.size(24.dp))
                SendMoneyAndCalculation()
                Spacer(modifier = Modifier.size(16.dp))
                DefaultText(
                    text = stringResource(id = R.string.title_transactions),
                    fontSize = 20.sp,
                    style = TextStyle(color = ColorDarkPrimary, fontWeight = FontWeight.SemiBold)
                )
                Spacer(modifier = Modifier.size(8.dp))
                TransactionFilterHeader(currentPage, items)
            }
        }
        items(5) {
            TransactionItem()
        }
    }
}

@Composable
private fun TransactionFilterHeader(currentPage: Int, items: Array<String>) {
    var currentPage1 = currentPage
    TabRow(
        selectedTabIndex = currentPage1,
        containerColor = Color.Transparent,
        contentColor = ColorSecondaryText,
        divider = { Divider() },
        indicator = {}
    ) {
        items.forEachIndexed { index, text ->
            Tab(modifier = if (index == currentPage1) Modifier
                .padding(4.dp)
                .height(30.dp)
                .background(color = ColorYourBudgetBackground, shape = RoundedCornerShape(6.dp))
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
private fun TransactionItem() {
    Card(
        modifier = Modifier.padding(4.dp),
        colors = CardDefaults.cardColors(Color.White),
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

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ChartCard(pagerState: PagerState) {
    Card(
        Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(16.dp),
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TitleChart()
            Spacer(modifier = Modifier.size(32.dp))
            ChartSlide(pagerState)
        }
    }
}

@Composable
private fun TitleChart() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        DefaultText(
            text = stringResource(id = R.string.text_axess_platinum_card),
            style = TextStyle(color = ColorDarkPrimary)
        )
        DefaultText(
            text = stringResource(id = R.string.text_add_budget),
            style = TextStyle(color = ColorPrimary)
        )
    }
}

@Composable
@OptIn(ExperimentalPagerApi::class)
private fun ChartSlide(pagerState: PagerState) {
    HorizontalPager(count = 3, state = pagerState) {
        ChartProgress()
    }
    DotsIndicator(
        modifier = Modifier.offset(y = (-12).dp),
        totalDots = 3,
        selectedIndex = pagerState.currentPage,
        selectedColor = ColorPrimary,
        unSelectedColor = ColorUnselectedDot,
        dotShape = RoundedCornerShape(4.dp),
        dotModifier = Modifier.size(width = 16.dp, height = 4.dp)
    )
}

@Composable
private fun SendMoneyAndCalculation() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Card(
            modifier = Modifier
                .weight(1F)
                .height(48.dp),
            colors = CardDefaults.cardColors(ColorYourBudgetBackground),
            elevation = CardDefaults.cardElevation(0.dp),
            shape = RoundedCornerShape(6.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Row {
                    Spacer(modifier = Modifier.size(16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_send_money),
                        contentDescription = "Icon Facebook"
                    )
                    Spacer(modifier = Modifier.size(12.dp))
                    DefaultText(
                        text = stringResource(id = R.string.text_send_money),
                        style = TextStyle(color = ColorPrimary)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.size(12.dp))
        Card(
            modifier = Modifier
                .weight(1F)
                .height(48.dp),
            colors = CardDefaults.cardColors(ColorYourBudgetBackground),
            elevation = CardDefaults.cardElevation(0.dp),
            shape = RoundedCornerShape(6.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Row {
                    Spacer(modifier = Modifier.size(16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_calculation),
                        contentDescription = "Icon Google"
                    )
                    Spacer(modifier = Modifier.size(12.dp))
                    DefaultText(
                        text = stringResource(id = R.string.text_calculation),
                        style = TextStyle(color = ColorPrimary)
                    )
                }
            }
        }
    }
}

@Composable
fun ChartProgress(
    data: Float = 20f,
    size: Dp = 250.dp,
    thickness: Dp = 16.dp,
    animationDuration: Int = 1000,
    foregroundIndicatorColor: Color = ColorPrimary,
    backgroundIndicatorColor: Color = Color(0xFFDFE7F5),
    startAngle: Float = 150f,
    dataPlanLimit: Float = 100F
) {
    var dataR by remember { mutableStateOf(-1f) }
    val gapBetweenEnds = (startAngle - 90) * 2
    val animateNumber = animateFloatAsState(
        targetValue = dataR,
        animationSpec = tween(durationMillis = animationDuration)
    )
    LaunchedEffect(Unit) { dataR = data }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.size(size)) {
            Canvas(modifier = Modifier.size(size = size)) {
                drawArc(
                    color = backgroundIndicatorColor,
                    startAngle = startAngle,
                    sweepAngle = 360f - gapBetweenEnds,
                    useCenter = false,
                    style = Stroke(width = thickness.toPx(), cap = StrokeCap.Round)
                )
                val sweepAngle = (animateNumber.value / dataPlanLimit) * (360f - gapBetweenEnds)
                drawArc(
                    color = foregroundIndicatorColor,
                    startAngle = startAngle,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    style = Stroke(thickness.toPx(), cap = StrokeCap.Round)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 56.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_chart_card),
                    contentDescription = "Chart Card"
                )
                Spacer(modifier = Modifier.size(16.dp))
                DefaultText(
                    text = stringResource(id = R.string.text_your_are_spent),
                    style = TextStyle(color = ColorSecondaryText),
                    fontSize = 13.sp
                )
                Spacer(modifier = Modifier.size(4.dp))
                DefaultText(
                    text = "$6,390",
                    style = TextStyle(color = ColorDarkPrimary, fontWeight = FontWeight.Bold),
                    fontSize = 30.sp
                )
                Spacer(modifier = Modifier.size(4.dp))
                DefaultText(
                    text = "of $3,248",
                    style = TextStyle(color = ColorSecondaryText),
                    fontSize = 13.sp
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .offset(y = (-50).dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val textStyle = TextStyle(color = ColorSecondaryText)
            DefaultText(
                modifier = Modifier.padding(start = 20.dp),
                text = stringResource(id = R.string.text_min_percentage),
                style = textStyle
            )
            DefaultText(
                text = stringResource(id = R.string.text_max_percentage),
                style = textStyle
            )
        }

    }

}
