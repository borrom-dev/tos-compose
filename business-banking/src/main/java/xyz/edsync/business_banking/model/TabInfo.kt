package xyz.edsync.business_banking.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class TabInfo(
    @StringRes val titleRes: Int,
    @DrawableRes val iconRes: Int
)
