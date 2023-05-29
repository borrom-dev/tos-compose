package xyz.edsync.toscompose.feature.main

import xyz.edsync.common.util.model.Menu
import xyz.edsync.toscompose.R

fun getMenuItems(): MutableList<Menu> {
    val items = mutableListOf<Menu>()
    items.add(getTemplate())
    items.add(getGeneral())
    return items
}

private fun getTemplate(): Menu {
    return Menu(
        title = R.string.template,
        sampleNames = mutableListOf<Int>().apply {
            add(R.string.banking)
            add(R.string.apple_watch_menu)
        }
    )
}

private fun getGeneral(): Menu {
    return Menu(
        title = R.string.general,
        sampleNames = mutableListOf<Int>().apply {
            add(R.string.slide_transform)
            add(R.string.slide_indicator)
            add(R.string.background)
            add(R.string.shape)
        }
    )
}
