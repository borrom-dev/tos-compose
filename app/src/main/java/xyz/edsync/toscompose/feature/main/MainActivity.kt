package xyz.edsync.toscompose.feature.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import xyz.edsync.business_banking.feature.splash.BusinessBankingSlashActivity
import xyz.edsync.common.util.listener.ItemClickListener
import xyz.edsync.toscompose.R

class MainActivity : ComponentActivity(), ItemClickListener<Int> {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainContent(this) }
    }

    override fun onItemClicked(item: Int) {
        when(item) {
            R.string.banking -> gotoBanking()
        }
    }

    private fun gotoBanking() {
        val intent = Intent(this,  BusinessBankingSlashActivity::class.java)
        startActivity(intent)
    }

}
