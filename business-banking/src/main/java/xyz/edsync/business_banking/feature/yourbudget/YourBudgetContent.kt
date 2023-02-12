package xyz.edsync.business_banking.feature.yourbudget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(R.drawable.bg_your_budget),
                    contentDescription = "backgroundImage",
                )
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
    Column(modifier = Modifier.fillMaxSize()) {
        Card(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            backgroundColor = Color.White
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
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
            }
        }
    }
}
