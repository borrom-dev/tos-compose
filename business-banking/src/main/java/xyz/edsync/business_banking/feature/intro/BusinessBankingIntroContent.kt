package xyz.edsync.business_banking.feature.intro

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import xyz.edsync.business_banking.feature.login.TopBar
import xyz.edsync.business_banking.ui.theme.BusinessBankingTheme

@Composable
fun BusinessBankingIntroContent() {
    BusinessBankingTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = { TopBar() },
            ) {
                Content()
            }
        }
    }
}

@Composable
private fun Content() {

}
