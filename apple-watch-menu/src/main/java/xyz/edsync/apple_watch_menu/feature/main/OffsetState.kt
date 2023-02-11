package xyz.edsync.apple_watch_menu.feature.main

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector2D
import androidx.compose.ui.geometry.Offset

interface OffsetState {
    val currentOffset: Offset
        get() = animatable.value

    val animatable: Animatable<Offset, AnimationVector2D>

    suspend fun snapTo(offset: Offset)
    suspend fun animateTo(offset: Offset, velocity: Offset)
    suspend fun stop()
}
