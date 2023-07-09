package xyz.edsync.toscompose.feature.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import xyz.edsync.apple_watch_menu.feature.main.AppleWatchMenuActivity
import xyz.edsync.business_banking.feature.splash.BusinessBankingSlashActivity
import xyz.edsync.common.util.listener.ItemClickListener
import xyz.edsync.slidetransfom.feature.SlideTransformActivity
import xyz.edsync.toscompose.R

class MainActivity : ComponentActivity(), ItemClickListener<Int> {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent(listener = this)
        }
    }

    override fun onItemClicked(item: Int) {
        when (item) {
            R.string.banking -> gotoBanking()
            R.string.apple_watch_menu -> goToAppleWatchMenu()
            R.string.slide_transform -> gotToSlideTransform()
        }
    }

    private fun gotoBanking() {
        val intent = Intent(this, BusinessBankingSlashActivity::class.java)
        startActivity(intent)
    }

    private fun goToAppleWatchMenu() {
        val intent = Intent(this, AppleWatchMenuActivity::class.java)
        startActivity(intent)
    }

    private fun gotToSlideTransform() {
        val intent = Intent(this, SlideTransformActivity::class.java)
        startActivity(intent)
    }

}
