package com.akiapps.frameworklib.generaldetails

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class GeneralDetails(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val title: String,
    val description: String
)
