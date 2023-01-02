package com.akiapps.framework.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface InformationDao {

    @Query("SELECT * FROM information")
    suspend fun getInfoList(): ArrayList<InformationEntity>

    @Insert
    suspend fun addInformation(informationEntity: InformationEntity)
}