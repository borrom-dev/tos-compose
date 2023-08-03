package xyz.edsync.slidetransfom.feature.slidestack

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import xyz.edsync.common.util.theme.TosComposeTheme
import xyz.edsync.common.util.ui.DefaultText
import xyz.edsync.slidetransfom.R

@Composable
internal fun SlideStackContent() {
    TosComposeTheme {
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                TopBar()
            }, floatingActionButton = {

            }) { paddingValues ->
            Body(paddingValues = paddingValues)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar() {
    TopAppBar(title = {
        DefaultText(
            text = stringResource(id = R.string.slide_stack),
            fontSize = 20.sp,
            style = TextStyle(color = Color.Black, fontWeight = FontWeight.SemiBold)
        )
    },
        modifier = Modifier.fillMaxWidth(),
        actions = {
        })
}

@Composable
private fun Body(paddingValues: PaddingValues) {

}
