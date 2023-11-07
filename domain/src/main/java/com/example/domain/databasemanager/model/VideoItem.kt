package com.example.domain.databasemanager.model


import android.net.Uri
import androidx.media3.common.MediaItem

data class VideoItem(
    val content: Uri,
    val mediaItem: MediaItem,
    val name: String
){
    companion object {

    }
}