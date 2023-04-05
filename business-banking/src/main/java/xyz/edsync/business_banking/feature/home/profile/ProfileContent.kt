package xyz.edsync.business_banking.feature.home.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.edsync.business_banking.R
import xyz.edsync.business_banking.feature.home.profile.model.GroupProfileMenu
import xyz.edsync.business_banking.feature.home.profile.model.ProfileMenu
import xyz.edsync.business_banking.ui.theme.BusinessBankingTheme
import xyz.edsync.business_banking.ui.theme.ColorBackground
import xyz.edsync.business_banking.ui.theme.ColorDarkPrimary
import xyz.edsync.business_banking.ui.theme.ColorSecondaryText
import xyz.edsync.common.util.ui.DefaultText

@Composable
fun ProfileContent() {
    BusinessBankingTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxWidth()) {
                BackgroundImage()
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

@Composable
private fun Content() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Card(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            shape = RoundedCornerShape(12.dp),
            backgroundColor = Color.White,
            elevation = 1.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_ricardo),
                    contentDescription = "Profile Picture"
                )
                Spacer(modifier = Modifier.size(16.dp))
                Row {
                    DefaultText(
                        text = "Ricardo Joseph",
                        style = TextStyle(color = ColorDarkPrimary, fontSize = 16.sp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_verified),
                        contentDescription = "verified"
                    )
                }
                Spacer(modifier = Modifier.size(8.dp))
                DefaultText(
                    text = "ricardojoseph@gmail.com",
                    style = TextStyle(color = ColorSecondaryText, fontSize = 13.sp)
                )
                Spacer(modifier = Modifier.size(24.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_badge),
                    contentDescription = "badged"
                )
            }
        }
        val menus = GroupProfileMenu.getItems()
        menus.forEach {
            Spacer(modifier = Modifier.size(8.dp))
            DefaultText(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = stringResource(id = it.title),
                style = TextStyle(color = ColorSecondaryText, fontSize = 13.sp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                it.profileMenus.forEach { item ->
                    ItemContent(profileMenu = item)
                }
            }
        }
        Spacer(modifier = Modifier.size(8.dp))
    }
}

@Composable
private fun ItemContent(profileMenu: ProfileMenu) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        backgroundColor = Color.White,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = profileMenu.icon), contentDescription = "icon")
            Column(
                modifier = Modifier
                    .width(0.dp)
                    .weight(weight = 1F)
                    .padding(start = 8.dp)
            ) {
                DefaultText(
                    text = stringResource(id = profileMenu.title),
                    style = TextStyle(color = ColorDarkPrimary),
                    fontSize = 16.sp
                )
                DefaultText(
                    text = stringResource(id = profileMenu.subtitle),
                    style = TextStyle(color = ColorSecondaryText),
                    fontSize = 13.sp
                )
            }
            Image(
                modifier = Modifier.padding(end = 16.dp),
                painter = painterResource(id = R.drawable.ic_right),
                contentDescription = "right"
            )
        }
    }
}

@Composable
private fun BackgroundImage() {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = ColorBackground),
        painter = painterResource(R.drawable.bg_your_budget),
        contentDescription = "backgroundImage",
    )
}

@Composable
private fun TopBar() {
    TopAppBar(title = {
        DefaultText(
            text = stringResource(id = R.string.text_profile),
            fontSize = 20.sp,
            style = TextStyle(color = Color.White, fontWeight = FontWeight.SemiBold)
        )
    },
        modifier = Modifier.fillMaxWidth(),
        elevation = 0.dp,
        backgroundColor = Color.Transparent,
        actions = {
            IconButton(onClick = { }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_edit_profile),
                    contentDescription = "Edit Profile"
                )
            }
        })
}