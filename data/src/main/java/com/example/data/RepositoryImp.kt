package com.example.data

import com.example.data.platform.NetworkHandler
import com.example.domain.databasemanager.ILocalDataSource
import com.example.domain.databasemanager.WordDao
import com.example.domain.databasemanager.localDatabaseEntities.WordEntity
import com.example.domain.databasemanager.model.Word
import com.example.domain.databasemanager.repository.MaterialRepository
import com.example.domain.databasemanager.repository.toWordEntityList
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

    override fun createWords(listWords: List<WordEntity>): Either<Failure, Long> {
        var success = 0L

            listWords.forEach{
                wordDao.insertWord(it)
            }
        return try {
            when (success) {
                0L -> Either.Right(success)
                1L -> Either.Left(Failure.ServerError)
                else -> Either.Left(Failure.ServerError)
            }
        } catch (exception: Throwable) {
            Either.Left(Failure.ServerError)
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

    override fun initialSetup(listWords: List<Word>): Either<Failure, Long> {
        return localMaterialRepository.createWords(listWords.toWordEntityList())
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