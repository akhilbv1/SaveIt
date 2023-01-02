package com.akiapps.framework

import com.akiapps.framework.room.InformationDatabase
import com.akiapps.framework.room.InformationEntity

interface LocalRepository {
    suspend fun getInfoList(): ArrayList<InformationEntity>
    suspend fun addInfo(informationEntity: InformationEntity)
}

class LocalRepositoryImpl(private val informationDatabase: InformationDatabase): LocalRepository{
    override suspend fun getInfoList(): ArrayList<InformationEntity> {
        return informationDatabase.informationDao().getInfoList()
    }

    override suspend fun addInfo(informationEntity: InformationEntity) {
        informationDatabase.informationDao().addInformation(informationEntity)
    }
}