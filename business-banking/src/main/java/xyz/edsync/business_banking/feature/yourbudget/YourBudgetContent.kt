package xyz.edsync.business_banking.feature.yourbudget

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
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
import xyz.edsync.business_banking.R
import xyz.edsync.business_banking.ui.theme.BusinessBankingTheme
import xyz.edsync.business_banking.ui.theme.ColorBackground
import xyz.edsync.business_banking.ui.theme.ColorDarkPrimary
import xyz.edsync.business_banking.ui.theme.ColorPrimary
import xyz.edsync.common.util.ui.DefaultText

@Composable
fun YourBudgetContent() {
    BusinessBankingTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Box {
                Column(modifier = Modifier.fillMaxSize()) {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = ColorBackground),
                        painter = painterResource(R.drawable.bg_your_budget),
                        contentDescription = "backgroundImage",
                    )
                    Spacer(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = ColorBackground)
                    )
                }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopBar() },
                    backgroundColor = Color.Transparent
                ) {
                    Content()
                }
            }
        }
    }
}

@Composable
private fun TopBar() {
    TopAppBar(title = {
        DefaultText(
            text = stringResource(id = R.string.title_your_budget),
            fontSize = 20.sp,
            style = TextStyle(color = Color(0xFFD8D8D8), fontWeight = FontWeight.SemiBold)
        )
    },
        modifier = Modifier.fillMaxWidth(),
        elevation = 0.dp,
        backgroundColor = Color.Transparent,
        actions = {
            IconButton(onClick = { }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_notification),
                    contentDescription = "Notification"
                )
            }
        })
}

@Composable
private fun Content() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.size(8.dp))
        Card(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            backgroundColor = Color.White,
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
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
                Spacer(modifier = Modifier.size(24.dp))
                ChartProgress()
            }
        }
        Spacer(modifier = Modifier.size(24.dp))
        SendMoneyAndCalculation()
    }
}

@Composable
private fun SendMoneyAndCalculation() {
    val colorBackground = Color(0xFFDFE7F5)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Card(
            modifier = Modifier
                .weight(1F)
                .height(48.dp),
            backgroundColor = colorBackground,
            elevation = 0.dp,
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
                    DefaultText(text = "Send Money", style = TextStyle(color = ColorPrimary))
                }
            }
        }
        Spacer(modifier = Modifier.size(12.dp))
        Card(
            modifier = Modifier
                .weight(1F)
                .height(48.dp),
            backgroundColor = colorBackground,
            elevation = 0.dp,
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
                    DefaultText(text = "Calculation", style = TextStyle(color = ColorPrimary))
                }
            }
        }
    }
}

@Composable
fun ChartProgress(
    data: Float = 20f,
    dataTextStyle: TextStyle = TextStyle(
        fontSize = MaterialTheme.typography.h3.fontSize
    ),
    remainingTextStyle: TextStyle = TextStyle(
        fontSize = 16.sp
    ),
    size: Dp = 250.dp,
    thickness: Dp = 16.dp,
    animationDuration: Int = 1000,
    foregroundIndicatorColor: Color = ColorPrimary,
    backgroundIndicatorColor: Color = Color(0xFFDFE7F5),
    startAngle: Float = 150f,
    dataPlanLimit: Float = 100F
) {
    // It remembers the number value
    var dataR by remember { mutableStateOf(-1f) }

    val gapBetweenEnds = (startAngle - 90) * 2

    // Number Animation
    val animateNumber = animateFloatAsState(
        targetValue = dataR,
        animationSpec = tween(durationMillis = animationDuration)
    )

    // This is to start the animation when the activity is opened
    LaunchedEffect(Unit) {
        dataR = data
    }

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
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .offset(y = (-50).dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val color = Color(0xFF77869E)
            DefaultText(
                modifier = Modifier.padding(start = 20.dp),
                text = "0%",
                style = TextStyle(color = color)
            )
            DefaultText(
                text = "100%",
                style = TextStyle(color = color)
            )
        }

    }

}
