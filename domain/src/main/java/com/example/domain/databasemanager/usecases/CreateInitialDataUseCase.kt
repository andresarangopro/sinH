package com.example.domain.databasemanager.usecases

import com.example.domain.databasemanager.model.UseCase
import com.example.domain.databasemanager.model.Word
import com.example.domain.databasemanager.repository.MaterialRepository
import com.old.domain.model.Either
import com.old.domain.model.Failure
import javax.inject.Inject

class CreateInitialDataUseCase
@Inject constructor(private val materialRepository: MaterialRepository) : UseCase<Long, CreateInitialDataUseCase.Params>() {

    override suspend fun run(params: Params): Either<Failure, Long>  = materialRepository.initialSetup(params.listWords)

    data class Params(val listWords: List<Word>)
}

