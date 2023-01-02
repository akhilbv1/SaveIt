package com.akiapps.data

sealed interface InfoType {
    data class Card(val cardDetails: com.akiapps.data.CardDetails) : InfoType
    data class Password(val passwordDetails: PasswordDetails): InfoType
    data class General(val generalDetails: com.akiapps.data.GeneralDetails): InfoType
}
