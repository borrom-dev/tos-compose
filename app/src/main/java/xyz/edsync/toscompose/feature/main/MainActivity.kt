package xyz.edsync.toscompose.feature.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import xyz.edsync.apple_watch_menu.feature.main.AppleWatchMenuActivity
import xyz.edsync.business_banking.feature.splash.BusinessBankingSlashActivity
import xyz.edsync.common.util.listener.ItemClickListener
import xyz.edsync.common.util.ui.ImageSlider
import xyz.edsync.quiz_game.feature.start.StartQuizActivity
import xyz.edsync.slidetransfom.feature.SlideTransformActivity
import xyz.edsync.toscompose.R

class MainActivity : ComponentActivity(), ItemClickListener<Int> {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageSlider(
                itemsCount = 10

            )
        }
    }

    override fun onItemClicked(item: Int) {
        when (item) {
            R.string.banking -> gotoBanking()
            R.string.quiz_question -> gotoQuizQuestion()
            R.string.apple_watch_menu -> goToAppleWatchMenu()
            R.string.slide_transform -> gotToSlideTransform()
        }
    }

    private fun gotoQuizQuestion() {
        Intent(this, StartQuizActivity::class.java).apply {
            startActivity(this)
        }
    }

    private fun gotoBanking() {
        Intent(this, BusinessBankingSlashActivity::class.java).apply {
            startActivity(this)
        }
    }

    private fun goToAppleWatchMenu() {
        Intent(this, AppleWatchMenuActivity::class.java).apply {
            startActivity(this)
        }
    }

    private fun gotToSlideTransform() {
        Intent(this, SlideTransformActivity::class.java).apply {
            startActivity(this)
        }
    }

}
