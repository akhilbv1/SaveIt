package com.akiapps.data

sealed interface CardType{
    object Debit: CardType
    object Credit: CardType
}
