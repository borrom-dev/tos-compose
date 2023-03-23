package xyz.edsync.pageindicator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import xyz.edsync.pageindicator.ui.theme.TosComposeTheme

class PageIndicatorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TosComposeTheme {
                PageIndicatorContent()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PageIndicatorContent()
}