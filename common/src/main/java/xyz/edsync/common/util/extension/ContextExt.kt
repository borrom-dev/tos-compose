package xyz.edsync.common.util.extension

import android.content.Context
import android.content.Intent
import android.net.Uri

fun Context.openUrl(url: String) {
    Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
        startActivity(this)
    }
}
