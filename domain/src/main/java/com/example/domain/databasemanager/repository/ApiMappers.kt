package com.example.domain.databasemanager.repository

import com.example.domain.databasemanager.localDatabaseEntities.WordEntity
import com.example.domain.databasemanager.model.Word

fun List<WordEntity>.toWordList():List<Word> = this.map {
    it.run {
        Word(
          word, letter, image, video
        )
    }
}