package com.example.logogenia.presentation.ui.wordDetail

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.core.net.toUri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import androidx.media3.common.Player
import com.example.domain.databasemanager.model.VideoItem
import com.example.domain.databasemanager.model.Word
import com.example.domain.databasemanager.usecases.GetWordsByLetterUseCase
import com.example.logogenia.presentation.navigation.RouteNavigator
import com.example.logogenia.presentation.ui.player.ExoPlayerProvider
import com.old.domain.model.Failure
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class WordDetailViewModel @Inject constructor(
    val savedStateHandle: SavedStateHandle,
    private val routeNavigator: RouteNavigator,
    private val getWordsByLetterUseCase: GetWordsByLetterUseCase,
    val player: ExoPlayerProvider
): ViewModel(),RouteNavigator by routeNavigator {

    private val _letter: MutableLiveData<String> = MutableLiveData()
    val letter: LiveData<String> = _letter

    private val _allWords: MutableLiveData<List<Word>> = MutableLiveData()
    val allWords: LiveData<List<Word>> = _allWords

    private val _failure: MutableLiveData<Failure> = MutableLiveData()
    val failure: LiveData<Failure> = _failure

    private val _status: MutableLiveData<States<WordDetailsStatus>> = MutableLiveData()
    val status: LiveData<States<WordDetailsStatus>> = _status

    private val _wordPosition : MutableLiveData<Int> = MutableLiveData(0)
    val wordPosition: LiveData<Int> = _wordPosition

    private val _word : MutableLiveData<Word> = MutableLiveData()
    val word: LiveData<Word> = _word

    private val videoUris = savedStateHandle.getStateFlow("videoUris", emptyList<Uri>())

    val mediaItems = arrayListOf<MediaItem>()
    val videoItems = videoUris.map { uris ->
        uris.map { uri ->
            VideoItem(
                content = uri,
                mediaItem = MediaItem.fromUri(uri),
                name =  "No name"
            )
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())


    fun Uri.toVideoItem() = VideoItem(
        this,
        MediaItem.fromUri(this),
        "No name"
    )

    fun addVideoUr(uri: Uri) {
        savedStateHandle["videoUris"] = videoUris.value + uri
        player.getExoPlayer()?.addMediaItem(MediaItem.fromUri(uri))
    }

    fun playVid(uri: Uri) {
        player.getExoPlayer()?.setMediaItem(
            videoItems.value.find { it.content == uri }?.mediaItem ?: return
        )
    }

    init {
         player.initialize()
          player.prepare()
        _letter.value = WordDetailRoute.getStringFrom(savedStateHandle)
        _letter.value?.let { letter ->
            loadAllWordsData(letter)
        }
        Log.d("INNVIEWM", "${allWords.value?.size}")
    }

    private fun loadAllWordsData(letter : String) =
            getWordsByLetterUseCase(GetWordsByLetterUseCase.Params(letter), viewModelScope) { it.fold(::handleFailure, ::handleTopRatedMovieList) }


    private fun handleTopRatedMovieList( words: List<Word>) {
        Log.d("INNVIEWM","${words?.size}")
        _allWords.value = words
        _word.value = wordPosition.value?.let { allWords.value?.get(it) }

        allWords.value?.let {
            addVideoUri(it[wordPosition.value?:0].video)
        }
        _status.value = States(WordDetailsStatus.ShowWords(words))
    }
    private fun handleFailure(failure: Failure) {
        Log.d("FALLO","$failure")
        _failure.value = failure
    }

    fun playVideo(){
        var uri: Uri?= allWords.value!!.get(wordPosition.value?:0).video.toUri()
        player.getExoPlayer()?.addMediaItem(MediaItem.fromUri(uri!!))

        uri = Uri.parse("https://drive.google.com/file/d/1Zo8cmOYeV6SK4fTcY8eIAdr1zVRDIwPj/view?usp=drive_link")
        player.getExoPlayer()?.setMediaItem(
            uri.toVideoItem().mediaItem
        )
    }

    fun addVideoUri(uri: String){
        player.getExoPlayer()?.setMediaItem(
            MediaItem.fromUri(uri)
        )

        player.getExoPlayer()?.addListener(object : Player.Listener {
            override fun onMediaItemTransition(mediaItem: MediaItem?, reason: Int) {
                if (reason == Player.MEDIA_ITEM_TRANSITION_REASON_AUTO) {
                    Log.d("SETMEDIA","$reason")
                }else{
                    Log.d("SETMEDIAFALLO","$reason")
                }
            }
        })
    }

    sealed class WordDetailsStatus {
        data class ShowWords(val listOfWords : List<Word>):WordDetailsStatus()
    }

}


data class States<out T>(private val content:T) {

    private var hasBeenHandled = false

    fun getContentIfNotHandled(): T? = if (hasBeenHandled) {
        null
    } else {
        hasBeenHandled = true
        content
    }
}