package xyz.edsync.business_banking.feature.home.wallet

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.edsync.business_banking.R
import xyz.edsync.business_banking.ui.theme.BusinessBankingTheme
import xyz.edsync.business_banking.ui.theme.ColorBackground
import xyz.edsync.business_banking.ui.theme.ColorDarkPrimary
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
            }
        }
    }
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
