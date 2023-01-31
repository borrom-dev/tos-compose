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
    TopAppBar(title = {},
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

        })
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
        Spacer(modifier = Modifier.size(16.dp))
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(48.dp),
            onClick = { }
        ) {
            DefaultText(
                text = stringResource(id = R.string.btn_login),
                style = TextStyle(color = Color.White)
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            DefaultText(
                text = stringResource(id = R.string.text_dont_have_a_acount),
                style = TextStyle(color = Color(0xFFD8D8D8))
            )
            Spacer(modifier = Modifier.size(4.dp))
            DefaultText(
                text = stringResource(id = R.string.text_sign_up),
                style = TextStyle(color = ColorDarkPrimary, fontWeight = FontWeight.Bold)
            )
        }
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
