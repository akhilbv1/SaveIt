package com.akiapps.frameworklib.card

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CardDetailsDao {
    @Query("SELECT * FROM CardDetails")
    suspend fun getCardsList(): List<CardDetails>

    @Insert
    suspend fun addCard(cardDetails: CardDetails)
}