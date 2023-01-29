package xyz.edsync.toscompose.feature.banking.businessbanking.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.edsync.toscompose.R
import xyz.edsync.toscompose.feature.banking.businessbanking.ui.theme.BusinessBankingTheme
import xyz.edsync.toscompose.feature.banking.businessbanking.ui.theme.ColorDarkPrimary
import xyz.edsync.toscompose.util.ui.DefaultText

@Composable
fun LoginContent() {
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
fun TopBar() {
    TopAppBar(
        title = {},
        modifier = Modifier.fillMaxWidth(),
        elevation = 0.dp,
        backgroundColor = Color.White,
        navigationIcon = {
            IconButton(
                onClick = {},
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "Icon back"
                )
            }
        },
        actions = {

        }
    )
}

@Composable
fun Content() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        DefaultText(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = stringResource(id = R.string.title_welcome_login),
            fontSize = 32.sp,
            style = TextStyle(color = ColorDarkPrimary, fontWeight = FontWeight.Bold),
        )
        Spacer(modifier = Modifier.size(46.dp))
        LoginWithFacebookOrGoogle()
    }
}

@Composable
fun LoginWithFacebookOrGoogle() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Card(
            modifier = Modifier
                .weight(1F)
                .height(40.dp)
                .background(Color.White),
            backgroundColor = Color.White,
            elevation = 0.dp,
            border = BorderStroke(1.dp, Color(0xFF77869E)),
            shape = RoundedCornerShape(6.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_facebook),
                    contentDescription = "Icon Facebook"
                )
            }
        }
        Spacer(modifier = Modifier.size(8.dp))
        Card(
            modifier = Modifier
                .weight(1F)
                .height(40.dp)
                .background(Color.White),
            backgroundColor = Color.White,
            elevation = 0.dp,
            border = BorderStroke(1.dp, Color(0xFF77869E)),
            shape = RoundedCornerShape(6.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Icon Google"
                )
            }
        }
    }
}

@Preview()
@Composable
fun PreviewLoginScreen() {
    LoginContent()
}
