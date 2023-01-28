package xyz.edsync.toscompose.util.extension

import android.content.Context
import android.content.Intent
import android.net.Uri

fun Context.openUrl(url: String) {
    Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
        startActivity(this)
    }
}
