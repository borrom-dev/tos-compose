package xyz.edsync.business_banking.feature.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import xyz.edsync.business_banking.R
import xyz.edsync.business_banking.model.TabInfo
import xyz.edsync.business_banking.ui.theme.ColorSecondaryText
import xyz.edsync.common.util.ui.DefaultText
import xyz.edsync.toscompose.theme.TosComposeTheme

@Composable
fun HomeContent() {
    val tabs = mutableListOf(
        TabInfo(R.string.text_home, R.drawable.ic_banking_home),
        TabInfo(R.string.text_expenses, R.drawable.ic_banking_expenses),
        TabInfo(R.string.text_wallet, R.drawable.ic_banking_wallet),
        TabInfo(R.string.text_profile, R.drawable.ic_banking_profile)
    )
    TosComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column {
                TabRow(selectedTabIndex = 0) {
                    Tab(selected = true, onClick = {
                    }) {
                        tabs.forEach {
                            TabItem(IconRes = it.iconRes, titleRes = it.titleRes)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TabItem(
    @DrawableRes IconRes: Int,
    @StringRes titleRes: Int
) {
    Column {
        val title = stringResource(id = titleRes)
        Icon(
            painter = painterResource(id = IconRes),
            contentDescription = title
        )
        DefaultText(
            text = stringResource(id = titleRes),
            style = TextStyle(color = ColorSecondaryText)
        )
    }
}
