package xyz.edsync.business_banking.feature.intro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class BusinessBankingIntroActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { BusinessBankingIntroContent() }
    }

}
