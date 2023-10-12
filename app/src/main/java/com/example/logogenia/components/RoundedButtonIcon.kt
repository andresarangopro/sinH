package com.example.logogenia.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

@Composable
fun  RoundedButtonIcon(iconVector : Int, iconSize: Dp, onClick: () -> Unit){
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .padding(4.dp)
            .size(iconSize)
            .clip(RoundedCornerShape(iconSize/2))
            .fillMaxSize()
    ) {
        Image(
            painter = painterForVersionAndroid(imageRes = iconVector),
            contentDescription = ""
        )
    }
}