package com.akiapps.frameworklib

import com.akiapps.frameworklib.card.CardDetails
import com.akiapps.frameworklib.generaldetails.GeneralDetails
import com.akiapps.frameworklib.password.PasswordDetails


interface LocalRepository {
    suspend fun addPassWordInfo(passwordDetails: PasswordDetails)
    suspend fun getPasswordDetailsList(): List<PasswordDetails>

    suspend fun addCardDetailsInfo(cardDetails: CardDetails)
    suspend fun getCardDetailsList(): List<CardDetails>

    suspend fun addGeneralDetails(generalDetails: GeneralDetails)
    suspend fun getGeneralDetailsList(): List<GeneralDetails>
}

class LocalRepositoryImpl(private val informationDatabase: InformationDatabase): LocalRepository {
    override suspend fun addPassWordInfo(passwordDetails: PasswordDetails) {
        informationDatabase.passwordDetailsDao().addPasswordDetails(passwordDetails)
    }

    override suspend fun getPasswordDetailsList(): List<PasswordDetails> {
       return informationDatabase.passwordDetailsDao().getPasswordDetails()
    }

    override suspend fun addCardDetailsInfo(cardDetails: CardDetails) {
        informationDatabase.creditCardDetailsDao().addCard(cardDetails)
    }

    override suspend fun getCardDetailsList(): List<CardDetails> {
       return informationDatabase.creditCardDetailsDao().getCardsList()
    }

    override suspend fun addGeneralDetails(generalDetails: GeneralDetails) {
        informationDatabase.generalDetailsDao().addGeneralDetails(generalDetails)
    }

    override suspend fun getGeneralDetailsList(): List<GeneralDetails> {
        return informationDatabase.generalDetailsDao().getGenDetails()
    }
}