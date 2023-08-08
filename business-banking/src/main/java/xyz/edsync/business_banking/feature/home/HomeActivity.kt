package xyz.edsync.business_banking.feature.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import xyz.edsync.common.util.theme.TosComposeTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TosComposeTheme {
                HomeContent()
            }
        }
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }
}
