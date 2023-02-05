package xyz.edsync.business_banking.feature.intro

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import xyz.edsync.business_banking.R
import xyz.edsync.business_banking.feature.login.BusinessBankingLoginActivity
import xyz.edsync.business_banking.ui.theme.BusinessBankingTheme
import xyz.edsync.common.util.ui.DefaultText

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
private fun TopBar() {
    val context = LocalContext.current
    TopAppBar(title = {},
        modifier = Modifier.fillMaxWidth(),
        elevation = 0.dp,
        backgroundColor = Color.White,
        actions = {
            Text(
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        Toast
                            .makeText(context, "SKIP CLICKED", Toast.LENGTH_SHORT)
                            .show()
                    }, text = stringResource(id = R.string.text_skip), style = TextStyle(Color.Gray)
            )
        })
}

@Composable
private fun Content() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Buttons()
    }
}

@Composable
private fun Buttons() {
    val context = LocalContext.current
    Row(
        modifier = Modifier
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
