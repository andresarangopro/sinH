package com.example.domain.databasemanager

import com.example.domain.databasemanager.localDatabaseEntities.WordEntity

interface ILocalDataSource {
    fun getListWords(): List<WordEntity>
    fun getListWordsByLetter(letter : Char): List<WordEntity>
    fun createWord(listWords: List<WordEntity>)
    fun getDetailWord(word: String):WordEntity
}