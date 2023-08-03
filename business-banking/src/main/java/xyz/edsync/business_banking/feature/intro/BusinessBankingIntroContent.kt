package xyz.edsync.business_banking.feature.intro

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import xyz.edsync.business_banking.R
import xyz.edsync.business_banking.feature.login.BusinessBankingLoginActivity
import xyz.edsync.business_banking.ui.theme.BusinessBankingTheme
import xyz.edsync.business_banking.ui.theme.ColorDarkPrimary
import xyz.edsync.business_banking.ui.theme.ColorSecondaryText
import xyz.edsync.common.util.ui.DefaultText
import xyz.edsync.common.util.ui.DotsIndicator

@Composable
fun BusinessBankingIntroContent(onSkipPressed: () -> Unit) {
    BusinessBankingTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = { TopBar(onSkipPressed) },
            ) {
                Content(it)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(onSkipPressed: () -> Unit) {
    TopAppBar(title = {},
        modifier = Modifier.fillMaxWidth(),
        actions = {
            Text(
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        onSkipPressed()
                    }, text = stringResource(id = R.string.text_skip), style = TextStyle(Color.Gray)
            )
        })
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun Content(paddingValues: PaddingValues) {
    val pagerState = rememberPagerState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        SlideIntro(pagerState)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DotsIndicator(
                totalDots = 6,
                selectedIndex = pagerState.currentPage,
                selectedColor = ColorDarkPrimary,
                unSelectedColor = ColorSecondaryText
            )
            Buttons()
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun SlideIntro(pagerState: PagerState) {
    HorizontalPager(modifier = Modifier.fillMaxSize(), count = 6, state = pagerState) {
        SlideContent()
    }
}

@Composable
private fun SlideContent() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .padding(start = 25.dp),
            painter = painterResource(id = R.drawable.ic_iphone_x_blue),
            contentDescription = ""
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(vertical = 8.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp)
                )
                .align(Alignment.BottomCenter),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                DefaultText(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.text_intro_title),
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        color = ColorDarkPrimary,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Spacer(modifier = Modifier.size(4.dp))
                DefaultText(
                    text = stringResource(id = R.string.text_desc_intro),
                    style = TextStyle(
                        color = ColorSecondaryText,
                        textAlign = TextAlign.Center
                    ),
                    fontSize = 13.sp
                )
            }
        }
    }
}

@Composable
private fun Buttons(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(modifier = Modifier.weight(1F), onClick = { gotoLoginScreen(context) }) {
            DefaultText(
                text = stringResource(id = R.string.btn_login),
                style = TextStyle(color = Color.White)
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Button(modifier = Modifier.weight(1F), onClick = { }) {
            DefaultText(
                text = stringResource(id = R.string.text_sign_up),
                style = TextStyle(color = Color.White)
            )
        }
    }
}

private fun gotoLoginScreen(context: Context) {
    val intent = Intent(context, BusinessBankingLoginActivity::class.java)
    context.startActivity(intent)
}
