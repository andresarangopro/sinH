package com.example.domain.databasemanager.repository

import com.example.domain.databasemanager.entities.WordEntityRemote
import retrofit2.Call
import retrofit2.http.GET

interface MaterialApi {
    companion object {
        private const val WORDS = "words"
    }

    @GET(WORDS)
    fun words(): Call<List<WordEntityRemote>>
}