package com.example.logogenia.presentation.ui

import android.content.Context

val alphabet = listOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")

fun getDrawableId(resourceName : String, context : Context) = context.resources.getIdentifier(
    resourceName, "drawable", context.packageName)