package com.akiapps.frameworklib.card

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CardDetails(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val cardType: Int,
    val cardNumber: String,
    val cardCompany: String?,
    val cvv: String?,
    val expiry: String?,
    val cardName: String?
)
