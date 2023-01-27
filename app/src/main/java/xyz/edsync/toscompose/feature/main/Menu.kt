package xyz.edsync.toscompose.feature.main

import androidx.annotation.StringRes
import xyz.edsync.toscompose.R

data class Menu(
    @StringRes val title: Int,
    val sampleNames: MutableList<Int> = mutableListOf()
) {
    companion object {
        fun getItems(): MutableList<Menu> {
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
                }
            )
        }

        private fun getGeneral(): Menu {
            return Menu(
                title = R.string.general,
                sampleNames = mutableListOf<Int>().apply {
                    add(R.string.background)
                    add(R.string.shape)
                }
            )
        }
    }
}
