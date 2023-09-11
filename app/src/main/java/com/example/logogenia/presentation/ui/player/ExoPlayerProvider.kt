package com.example.logogenia.presentation.ui.player

import android.content.Context
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import javax.inject.Inject

class ExoPlayerProvider @Inject constructor(val context: Context) {
    private var exoPlayer: Player? = null

    fun initialize():Player {
        exoPlayer = ExoPlayer.Builder(context).build()

        return ExoPlayer.Builder(context)
            .build()
    }

    fun prepare(){
        exoPlayer?.prepare()
    }

    fun getExoPlayer(): Player? {
        return exoPlayer
    }

    fun release() {
        exoPlayer?.release()
        exoPlayer = null
    }
}