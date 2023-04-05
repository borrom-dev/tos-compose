package xyz.edsync.business_banking.feature.home.profile.model

import androidx.annotation.StringRes
import xyz.edsync.business_banking.R

data class GroupProfileMenu(
    @StringRes val title: Int,
    val profileMenus: List<ProfileMenu>
) {

    companion object {
        fun getItems(): List<GroupProfileMenu> {
            return arrayListOf<GroupProfileMenu>().apply {
                val groupProfileMenu =
                    GroupProfileMenu(R.string.title_general, arrayListOf<ProfileMenu>().apply {
                        add(
                            ProfileMenu(
                                R.drawable.ic_settings,
                                R.string.title_profile_settings,
                                R.string.subtitle_profile_settings
                            )
                        )
                        add(
                            ProfileMenu(
                                R.drawable.ic_security,
                                R.string.title_privacy,
                                R.string.subtitle_privacy
                            )
                        )
                        add(
                            ProfileMenu(
                                R.drawable.ic_general_notifictions,
                                R.string.title_notification,
                                R.string.subtitle_notification
                            )
                        )
                    })
                add(groupProfileMenu)
                val groupProfileMenu1 = GroupProfileMenu(
                    R.string.title_chart,
                    arrayListOf<ProfileMenu>().apply {
                        add(
                            ProfileMenu(
                                R.drawable.ic_chart,
                                R.string.title_show_volumes,
                                R.string.subtitle_show_volumes
                            )
                        )
                    }
                )
                add(groupProfileMenu1)
            }
        }
    }

}
