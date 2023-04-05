package xyz.edsync.business_banking.feature.home.profile.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ProfileMenu(
    @DrawableRes val icon: Int,
    @StringRes val title: Int,
    @StringRes val subtitle: Int
)
