package xyz.edsync.quiz_game.feature.start

import StartQuizContent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import xyz.edsync.toscompose.theme.TosComposeTheme

class StartQuizActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TosComposeTheme {
                StartQuizContent()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TosComposeTheme {
        StartQuizContent()
    }
}