package com.akiapps.frameworklib.generaldetails

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GeneralDetailsDao {

    @Query("SELECT * FROM GeneralDetails")
    suspend fun getGenDetails(): List<GeneralDetails>

    @Insert
    suspend fun addGeneralDetails(generalDetails: GeneralDetails)
}