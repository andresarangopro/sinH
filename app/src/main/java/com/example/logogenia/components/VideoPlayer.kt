package com.example.logogenia.components

import android.content.Context
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.media3.common.Player
import androidx.media3.ui.PlayerView

@Composable
fun VideoPlayer(player: Player?, width: Dp, lifecycle: Lifecycle.Event) {

        AndroidView(factory ={
            PlayerView(it).also {
                it.player = player
            }
        },
            modifier = androidx.compose.ui.Modifier
                .width(width)
                .aspectRatio(16 / 9f),
            update = {
                when (lifecycle) {
                    Lifecycle.Event.ON_PAUSE -> {
                        it.onPause()
                        it.player?.pause()
                    }
                    Lifecycle.Event.ON_RESUME -> {
                        it.onResume()
                    }
                    else -> Unit
                }
            },
        )
}
@Composable
fun VideoExoPlayer(player: Player?, width: Dp, lifecycle: Lifecycle.Event) {
        val exoPlayer = player
        DisposableEffect(AndroidView(factory ={
            PlayerView(it).also {
                it.player = player
            }
        },
            modifier = androidx.compose.ui.Modifier
                .width(width)
                .aspectRatio(16 / 9f),
            update = {
                when (lifecycle) {
                    Lifecycle.Event.ON_PAUSE -> {
                        it.onPause()
                        it.player?.pause()
                    }
                    Lifecycle.Event.ON_RESUME -> {
                        it.onResume()
                    }
                    else -> Unit
                }
            },
        )){
            onDispose { exoPlayer?.release() }
        }
}