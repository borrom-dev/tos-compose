package xyz.edsync.toscompose.feature.banking.businessbanking.splash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import xyz.edsync.toscompose.R
import xyz.edsync.toscompose.feature.banking.businessbanking.ui.theme.ColorPrimary
import xyz.edsync.toscompose.feature.main.ui.theme.TosComposeTheme
import xyz.edsync.toscompose.feature.banking.businessbanking.ui.theme.BusinessBankingTheme

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessBankingTheme {
                Surface(modifier = Modifier.fillMaxSize()) { SplashContent() }
            }
        }
    }
}

@Composable
fun SplashContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ColorPrimary),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier,
            painter = painterResource(id = R.drawable.ic_business_banking),
            contentDescription = "business banking"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TosComposeTheme {
        SplashContent()
    }
}
