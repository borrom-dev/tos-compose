package xyz.edsync.business_banking.feature.intro

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import xyz.edsync.business_banking.feature.home.HomeActivity

class BusinessBankingIntroActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessBankingIntroContent {
                gotoHomeScreen()
            }
        }
    }

    private fun gotoHomeScreen() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

}
