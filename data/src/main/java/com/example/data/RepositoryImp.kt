package com.example.data

import com.example.data.platform.NetworkHandler
import com.example.domain.databasemanager.ILocalDataSource
import com.example.domain.databasemanager.WordDao
import com.example.domain.databasemanager.localDatabaseEntities.WordEntity
import com.example.domain.databasemanager.model.Word
import com.example.domain.databasemanager.repository.MaterialRepository
import com.example.domain.databasemanager.repository.toWordList
import com.old.domain.model.Either
import com.old.domain.model.Failure
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalRepositoryDataSourceImp @Inject constructor(private val wordDao: WordDao): ILocalDataSource {
    override fun getListWords(): List<WordEntity> {
        return  wordDao.getAllWords()
    }

    override fun getListWordsByLetter(letter: Char): List<WordEntity> {
        return  wordDao.getAllWordsByLetter(letter)
    }

    override fun createWord(listWords: List<WordEntity>) {
        listWords.forEach{
            wordDao.insertWord(it)
        }
    }

    override fun getDetailWord(word: String): WordEntity {
        return wordDao.getWordDetail(word)
    }
}


@Suppress("KotlinConstantConditions")
class RepositoryImp
@Inject constructor(
    private val networkHandler: NetworkHandler,
    private val localMaterialRepository: LocalRepositoryDataSourceImp
) : MaterialRepository {
    override fun wordsByLetter(letter: Char): Either<Failure, List<Word>> {
        return getLocalWords(letter)
    }

    private fun getLocalWords(letter: Char): Either<Failure, List<Word>> {

        return try {
            val response = localMaterialRepository.getListWordsByLetter(letter)
            when (response.isNotEmpty()) {
                true -> Either.Right(response.toWordList())
                false -> Either.Left(Failure.ServerError)
            }
        } catch (exception: Throwable) {
            Either.Left(Failure.ServerError)
        }
    }

}