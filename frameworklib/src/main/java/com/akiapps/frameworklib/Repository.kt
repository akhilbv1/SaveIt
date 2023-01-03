package com.akiapps.frameworklib

import javax.inject.Inject

interface Repository {
    fun getLocalRepository(): LocalRepository
}

class RepositoryImpl @Inject constructor(private val informationDatabase: InformationDatabase) : Repository {
    override fun getLocalRepository(): LocalRepository {
        return LocalRepositoryImpl(informationDatabase)
    }
}