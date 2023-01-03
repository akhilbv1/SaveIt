package com.akiapps.datalib

sealed class CardType(val type: Int) {
    object CreditCard: CardType(CREDIT_CARD)
    object DebitCard: CardType(DEBIT_CARD)

    companion object {
        const val CREDIT_CARD = 1
        const val DEBIT_CARD = 2
    }
}
