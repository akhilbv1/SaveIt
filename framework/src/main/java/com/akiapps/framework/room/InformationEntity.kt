package com.akiapps.framework.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.akiapps.data.Device
import com.akiapps.data.InfoType
import java.util.Date

@Entity(tableName = "information")
data class InformationEntity(
    @PrimaryKey val informationId: Int,
    @ColumnInfo(name = "information") val information: InfoType,
    @ColumnInfo(name = "saved_date") val savedDate: Date,
    @ColumnInfo(name = "device") val device: Device?,
)