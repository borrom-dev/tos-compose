package xyz.edsync.slidetransfom.feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import xyz.edsync.common.util.listener.ItemClickListener
import xyz.edsync.slidetransfom.ui.theme.TosComposeTheme

class SlideTransformActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SlideTransformContent(listener = object : ItemClickListener<Int> {
                override fun onItemClicked(item: Int) {

                }
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TosComposeTheme {

    }
}