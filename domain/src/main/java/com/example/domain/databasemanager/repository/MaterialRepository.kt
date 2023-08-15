package com.example.domain.databasemanager.repository

import com.example.domain.databasemanager.model.Word
import com.old.domain.model.Either
import com.old.domain.model.Failure

interface MaterialRepository {
    fun wordsByLetter(letter: Char): Either<Failure, List<Word>>
}