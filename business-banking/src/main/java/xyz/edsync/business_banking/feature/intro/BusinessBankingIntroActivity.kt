package xyz.edsync.business_banking.feature.intro

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import xyz.edsync.business_banking.feature.yourbudget.YourBudgetActivity

class BusinessBankingIntroActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessBankingIntroContent {
                gotoYourBudget()
            }
        }
    }

    private fun gotoYourBudget() {
        val intent = Intent(this, YourBudgetActivity::class.java)
        startActivity(intent)
    }

}
