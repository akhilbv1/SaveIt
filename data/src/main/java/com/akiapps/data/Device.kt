package com.akiapps.data

sealed class Device {
    data class Android(val osVersion: String): Device()
    data class IOS(val osVersion: String): Device()
}
