package com.akiapps.frameworklib

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.akiapps.frameworklib.card.CardDetails
import com.akiapps.frameworklib.card.CardDetailsDao
import com.akiapps.frameworklib.generaldetails.GeneralDetails
import com.akiapps.frameworklib.generaldetails.GeneralDetailsDao
import com.akiapps.frameworklib.password.PasswordDetailsEntity
import com.akiapps.frameworklib.password.PasswordDetailsDao


@Database(entities = [CardDetails::class, PasswordDetailsEntity::class, GeneralDetails::class], version = 1)
@TypeConverters(DateConvertor::class)
abstract class InformationDatabase : RoomDatabase() {
    abstract fun creditCardDetailsDao(): CardDetailsDao
    abstract fun passwordDetailsDao(): PasswordDetailsDao
    abstract fun generalDetailsDao(): GeneralDetailsDao

    companion object {

        @Volatile
        private var INSTANCE: InformationDatabase? = null

        fun getDatabase(context: Context): InformationDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance

            synchronized(this) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    InformationDatabase::class.java,
                    "SaveIt"
                )
                builder.fallbackToDestructiveMigration()
                val instance = builder.build()
                INSTANCE = instance
                return instance
            }
        }
    }
}