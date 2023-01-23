package com.akiapps.frameworklib

import com.akiapps.frameworklib.InformationType.PasswordType
import com.akiapps.frameworklib.password.PasswordDetails
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class GetInformationUseCase @Inject constructor(private val repository: Repository) {

    suspend fun getPasswordDetails(): Flow<List<InformationType>> {
        return flow {
            repository.getLocalRepository().getPasswordDetailsList().map {
                it.map { PasswordType(PasswordDetails(it.passwordTitle,it.password)) }
            }.collect {
                emit(it)
            }
        }
    }
}