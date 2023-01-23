package com.akiapps.frameworklib

import com.akiapps.frameworklib.card.CardDetails
import com.akiapps.frameworklib.generaldetails.GeneralDetails
import com.akiapps.frameworklib.password.PasswordDetailsEntity
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow


class AddInformationUseCase @Inject constructor(private val repository: Repository) {
    suspend fun addPasswordInfo(passwordDetails: PasswordDetailsEntity): Flow<Int> {
       return repository.getLocalRepository().addPassWordInfo(passwordDetails)
    }

    suspend fun addGeneralDetailsInfo(generalDetails: GeneralDetails) {
        repository.getLocalRepository().addGeneralDetails(generalDetails)
    }

    suspend fun addCardDetailsInfo(cardDetails: CardDetails) {
        repository.getLocalRepository().addCardDetailsInfo(cardDetails)
    }
}