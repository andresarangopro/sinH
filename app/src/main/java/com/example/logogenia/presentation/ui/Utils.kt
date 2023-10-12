package com.example.logogenia.presentation.ui

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

val alphabet = listOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")

fun getDrawableId(resourceName : String, context : Context) = context.resources.getIdentifier(
    resourceName, "drawable", context.packageName)

abstract class BaseViewModel<in ViewEvent, ViewState >   : ViewModel(), IBaseViewModel {

    private val _screenState: MutableLiveData<ViewState?> = MutableLiveData()
    val screenState: MutableLiveData<ViewState?>
        get() = _screenState

    override fun postEvents(event: Any) {
        manageEvent(event)
    }
    protected abstract fun manageEvent(event: Any)
}

@Composable
fun <T : Any, L : LiveData<T>> LifecycleOwner.observeCompose(liveData: L, body: (T?) -> Unit) =
    liveData.observeAsState()

interface IBaseViewModel{
    fun postEvents(event: Any)
}
