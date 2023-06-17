package xyz.edsync.slidetransfom.feature.slidestack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class SlideStackActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SlideStackContent()
        }
    }

}
