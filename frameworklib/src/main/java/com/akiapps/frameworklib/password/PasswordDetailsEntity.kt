package com.akiapps.frameworklib.password

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "PasswordDetails")
data class PasswordDetailsEntity(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val passwordTitle: String,
    val password: String
)
