package com.akiapps.frameworklib

import com.akiapps.frameworklib.card.CardDetails
import com.akiapps.frameworklib.generaldetails.GeneralDetails
import com.akiapps.frameworklib.password.PasswordDetailsEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


interface LocalRepository {
    suspend fun addPassWordInfo(passwordDetails: PasswordDetailsEntity): Flow<Int>
    suspend fun getPasswordDetailsList(): Flow<List<PasswordDetailsEntity>>

    suspend fun addCardDetailsInfo(cardDetails: CardDetails)
    suspend fun getCardDetailsList(): Flow<List<CardDetails>>

    suspend fun addGeneralDetails(generalDetails: GeneralDetails)
    suspend fun getGeneralDetailsList(): Flow<List<GeneralDetails>>
}

class LocalRepositoryImpl(private val informationDatabase: InformationDatabase): LocalRepository {

    override suspend fun addPassWordInfo(passwordDetailsEntity: PasswordDetailsEntity): Flow<Int> {
        return flow {
            emit( informationDatabase.passwordDetailsDao().addPasswordDetails(passwordDetailsEntity).toInt())
        }
    }

    override suspend fun getPasswordDetailsList(): Flow<List<PasswordDetailsEntity>> {
       return flow {
           emit(informationDatabase.passwordDetailsDao().getPasswordDetails())
       }
    }

    override suspend fun addCardDetailsInfo(cardDetails: CardDetails) {
        informationDatabase.creditCardDetailsDao().addCard(cardDetails)
    }

    override suspend fun getCardDetailsList(): Flow<List<CardDetails>> {
       return flow {
           emit(informationDatabase.creditCardDetailsDao().getCardsList())
       }
    }

    override suspend fun addGeneralDetails(generalDetails: GeneralDetails) {
        informationDatabase.generalDetailsDao().addGeneralDetails(generalDetails)
    }

    override suspend fun getGeneralDetailsList(): Flow<List<GeneralDetails>> {
        return flow {
            emit(informationDatabase.generalDetailsDao().getGenDetails())
        }
    }
}