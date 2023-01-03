package com.akiapps.frameworklib.password

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PasswordDetailsDao {

    @Query("SELECT * FROM PasswordDetails")
    suspend fun getPasswordDetails(): List<PasswordDetails>

    @Insert
    suspend fun addPasswordDetails(passwordDetails: PasswordDetails)
}