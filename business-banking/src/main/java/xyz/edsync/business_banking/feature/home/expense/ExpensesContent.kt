package xyz.edsync.business_banking.feature.home.expense

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.edsync.business_banking.R
import xyz.edsync.business_banking.ui.theme.*
import xyz.edsync.common.util.ui.DefaultText

@Composable
fun ExpenseContent() {
    BusinessBankingTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = { TopBar() },
                backgroundColor = ColorBackground
            ) {
                Content()
            }
        }
    }
}

@Composable
private fun Content() {
    LazyColumn {
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                CardBalanceContent()
                FilterContent()
                DefaultText(
                    text = stringResource(id = R.string.title_spending_breakdown),
                    fontSize = 20.sp,
                    style = TextStyle(color = ColorDarkPrimary, fontWeight = FontWeight.SemiBold)
                )
                Spacer(modifier = Modifier.size(8.dp))
            }
        }
        item {
            SpendingBreakDownItem()
        }
    }
}

@Composable
private fun FilterContent() {
    val months = stringArrayResource(id = R.array.months)
    Row() {
        LazyRow(content = {
            items(months) {

            }
        })
    }
}

@Composable
private fun SpendingBreakDownItem() {
    Card(
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp),
        backgroundColor = Color.White,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(40.dp),
                painter = painterResource(id = R.drawable.ic_gas),
                contentDescription = "gas"
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // TODO to update string
                Column(horizontalAlignment = Alignment.Start) {
                    DefaultText(text = "Shell", style = TextStyle(color = Color.Black))
                    DefaultText(text = "17 Monday June", style = TextStyle(color = Color.Black))
                }
                DefaultText(text = "-$35,88", style = TextStyle(color = Color.Red))
            }
        }
    }
}

@Composable
private fun CardBalanceContent() {
    Spacer(modifier = Modifier.size(16.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CardBalance()
        Column {
            IncomeRow()
            Spacer(modifier = Modifier.size(8.dp))
            ExpenseRow()
        }
    }
}

@Composable
private fun CardBalance() {
    Column {
        DefaultText(
            text = stringResource(id = R.string.text_card_balance),
            style = TextStyle(color = ColorSecondaryText, fontSize = 13.sp)
        )
        Spacer(modifier = Modifier.size(8.dp))
        DefaultText(
            text = "$6,390",
            style = TextStyle(
                color = ColorDarkPrimary,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
private fun IncomeRow() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.ic_income_arrow_up),
            contentDescription = "Income"
        )
        Spacer(modifier = Modifier.size(8.dp))
        DefaultText(
            text = "$3,214",
            style = TextStyle(color = ColorIncome, fontSize = 12.sp)
        )
    }
}

@Composable
private fun ExpenseRow() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.ic_expense_arrow_down),
            contentDescription = "Expense"
        )
        Spacer(modifier = Modifier.size(8.dp))
        DefaultText(
            text = "$1,116",
            style = TextStyle(color = ColorExpense, fontSize = 12.sp)
        )
    }
}

@Composable
private fun TopBar() {
    TopAppBar(title = {
        DefaultText(
            text = stringResource(id = R.string.title_expenses),
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
                    painter = painterResource(id = R.drawable.ic_export),
                    contentDescription = "Export"
                )
            }
        })
}

@Preview
@Composable
fun Preview() {
    ExpenseContent()
}