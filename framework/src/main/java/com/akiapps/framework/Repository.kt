package com.akiapps.framework

import com.akiapps.framework.room.InformationDatabase

interface Repository {
    fun getLocalRepository(informationDatabase: InformationDatabase): LocalRepository
}

class RepositoryImpl() : Repository {
    override fun getLocalRepository(informationDatabase: InformationDatabase): LocalRepository {
        return LocalRepositoryImpl(informationDatabase)
    }
}