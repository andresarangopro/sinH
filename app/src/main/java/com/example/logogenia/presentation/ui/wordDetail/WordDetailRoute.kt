package com.example.logogenia.presentation.ui.wordDetail

import android.net.Uri
import android.util.Log
import android.view.View
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.logogenia.presentation.navigation.KEY_CONTENT_PAGE_INDEX
import com.example.logogenia.presentation.navigation.NavRoute
import com.example.logogenia.presentation.navigation.getOrThrow
import com.example.logogenia.presentation.ui.theme.GrayLight
import com.example.logogenia.presentation.ui.theme.LogogeniaTheme
import androidx.lifecycle.LifecycleEventObserver
object WordDetailRoute : NavRoute<WordDetailViewModel> {

    override val route = "wordDetail/{$KEY_CONTENT_PAGE_INDEX}"

    /**
     * Returns the route that can be used for navigating to this page.
     */
    fun get(index: String): String = route.replace("{$KEY_CONTENT_PAGE_INDEX}", "$index")

    fun getStringFrom(savedStateHandle: SavedStateHandle) =
        savedStateHandle.getOrThrow<String>(KEY_CONTENT_PAGE_INDEX)

    override fun getArguments(): List<NamedNavArgument> = listOf(
        navArgument(KEY_CONTENT_PAGE_INDEX) { type = NavType.StringType })


    @Composable
    override fun viewModel(): WordDetailViewModel = hiltViewModel()

    @Composable
    override fun Content(viewModel: WordDetailViewModel) =
        ContentPage(viewModel)
}


@Composable
fun ContentPage(
    wordDetailViewModel: WordDetailViewModel
) {

    LogogeniaTheme{
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(GrayLight)
                .padding(8.dp)

        ) {
            val states by wordDetailViewModel.status.observeAsState()

            var lifecycle by remember {
                mutableStateOf(Lifecycle.Event.ON_CREATE)
            }
            val lifecycleOwner = LocalLifecycleOwner.current
            DisposableEffect(lifecycleOwner){
                val observer = LifecycleEventObserver {_, event ->
                    lifecycle = event
                }
                lifecycleOwner.lifecycle.addObserver(observer)
                onDispose {
                    lifecycleOwner.lifecycle.removeObserver(observer)
                }
            }

            states?.getContentIfNotHandled().let {navigation ->
                when(navigation) {
                    is WordDetailViewModel.WordDetailsStatus.ShowWords -> {
                        empty(text = "holi")

                        val selectVideoLauncher = rememberLauncherForActivityResult(
                            contract = ActivityResultContracts.GetContent(),
                            onResult = {
                                it?.let {
                                    wordDetailViewModel::addVideoUri
                                }
                            }
                        )

                       DisposableEffect(
                           AndroidView(factory ={context ->
                               PlayerView(context).also {
                                   it.player = wordDetailViewModel.player
                               }
                           },
                               modifier = Modifier
                                   .fillMaxWidth()
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
                       ){
                           onDispose { wordDetailViewModel.player.release() }
                       }
                        wordDetailViewModel.addVideoUr(Uri.parse("https://drive.google.com/file/d/1MLPrAJiBi8yu1p30dUxmcQ2ntrr-wJOR/view?usp=drive_link"))
                        wordDetailViewModel.playVid(Uri.parse("https://drive.google.com/file/d/1MLPrAJiBi8yu1p30dUxmcQ2ntrr-wJOR/view?usp=drive_link"))

                    }
                    else ->{}
                }
            }
        }
    }


}
@Composable
fun empty(text : String){
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 8.dp, 0.dp, 8.dp)

    )
}
