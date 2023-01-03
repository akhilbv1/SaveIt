package com.akiapps.frameworklib

import com.akiapps.frameworklib.card.CardDetails
import com.akiapps.frameworklib.generaldetails.GeneralDetails
import com.akiapps.frameworklib.password.PasswordDetails
import javax.inject.Inject


class AddInformationUseCase @Inject constructor(private val repository: Repository) {
    suspend fun addPasswordInfo(passwordDetails: PasswordDetails) {
        repository.getLocalRepository().addPassWordInfo(passwordDetails)
    }

    suspend fun addGeneralDetailsInfo(generalDetails: GeneralDetails) {
        repository.getLocalRepository().addGeneralDetails(generalDetails)
    }

    suspend fun addCardDetailsInfo(cardDetails: CardDetails) {
        repository.getLocalRepository().addCardDetailsInfo(cardDetails)
    }
}