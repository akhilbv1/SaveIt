package com.akiapps.data

data class CardDetails(
    val cardType: CardType,
    val cardNumber: String,
    val cardCompany: String?,
    val cvv: String?,
    val expiry: String?,
    val cardName: String?
)
