package com.akiapps.saveit

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SaveItApp: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}