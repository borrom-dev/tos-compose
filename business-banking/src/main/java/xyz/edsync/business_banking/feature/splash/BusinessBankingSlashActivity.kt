package xyz.edsync.business_banking.feature.splash

import android.content.Intent
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
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import xyz.edsync.business_banking.R
import xyz.edsync.business_banking.feature.intro.BusinessBankingIntroActivity
import xyz.edsync.business_banking.feature.intro.BusinessBankingIntroContent
import xyz.edsync.business_banking.feature.login.BusinessBankingLoginActivity
import xyz.edsync.business_banking.ui.theme.BusinessBankingTheme
import xyz.edsync.business_banking.ui.theme.ColorPrimary

class BusinessBankingSlashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessBankingTheme {
                Surface(modifier = Modifier.fillMaxSize()) { SplashContent() }
            }
        }
        lifecycleScope.launch {
            delay(NEXT_SCREEN_DURATION)
            gotoLoginScreen()
        }
    }

    private fun gotoLoginScreen() {
        val intent = Intent(this, BusinessBankingIntroActivity::class.java)
        startActivity(intent)
        finish()
    }

    companion object {
        private const val NEXT_SCREEN_DURATION = 500L
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
    BusinessBankingTheme {
        SplashContent()
    }
}
