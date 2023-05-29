package xyz.edsync.common.util.model

import androidx.annotation.StringRes

data class Menu(
    @StringRes val title: Int,
    val sampleNames: MutableList<Int> = mutableListOf()
)
