package com.example.logogenia.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.logogenia.presentation.ui.getDrawableId


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardHandler(imageRes: String?, text: String, onClick: () -> Unit){
    Card( modifier = Modifier
        .fillMaxWidth(),
        onClick =  {
            onClick()
        }
      ) {
        Box( modifier = Modifier.fillMaxSize()){
            val request = ImageRequest.Builder(LocalContext.current).data(imageRes).allowHardware(false).build()
            AsyncImage(
                model = request,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp))
            )

            Row (modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .align(Alignment.BottomCenter)
            ){
                val drawableRightArrow = getDrawableId("arrow_left_ic", LocalContext.current)
                val drawableLeftArrow = getDrawableId("arrow_right_ic", LocalContext.current)
                RoundedButtonIcon(drawableRightArrow)
                RoundedButtonIcon(drawableLeftArrow)
                RoundedButtonIcon(drawableLeftArrow)
                RoundedButtonIcon(drawableLeftArrow)

            }
        }
    }
}
@Composable
@Preview
fun showCardHandler(){
    CardHandler("R.drawable.word_presentation","text"){}
}