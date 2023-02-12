package xyz.edsync.business_banking.feature.yourbudget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class YourBudgetActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YourBudgetContent()
        }
    }
}
