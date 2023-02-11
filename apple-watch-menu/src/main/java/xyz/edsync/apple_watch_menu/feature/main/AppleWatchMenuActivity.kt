package xyz.edsync.apple_watch_menu.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import xyz.edsync.apple_watch_menu.feature.main.Icons.appleIcons
import xyz.edsync.toscompose.theme.TosComposeTheme

class AppleWatchMenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TosComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TosComposeTheme {
                        WatchGridLayout(
                            modifier = Modifier
                                .size(300.dp)
                                .background(Color.Black),
                            rowItemsCount = 5,
                            itemSize = 80.dp
                        ) {
                            appleIcons.forEach { (res, name) ->
                                IconRounded(
                                    res = res
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
