package com.akiapps.frameworklib

import com.akiapps.frameworklib.password.PasswordDetails

sealed class InformationType {
    data class PasswordType(val passwordDetails: PasswordDetails): InformationType()
}