package com.example.logogenia.presentation.ui.knowingWords

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.logogenia.R
import com.example.logogenia.presentation.navigation.RouteNavigator
import com.example.logogenia.presentation.ui.home.NavigationComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KnowingWordsViewModel @Inject constructor(
    private val routeNavigator: RouteNavigator
): ViewModel(), RouteNavigator by routeNavigator {


    val cards = listOf(
        NavigationComponent(R.drawable.word_presentation, "Te presento las palabras",
            { toKnowingWords() }),
        NavigationComponent(R.drawable.how_start_img, "¿Cómo empieza esta palabra?",
            { toKnowingWords() })
    )


    fun toKnowingWords(){
        Log.d("DIOS","uhmmm")
        routeNavigator.navigateToRoute(KnowingWordsRoute.get(0))
    }

    init {


    }

}
