package com.akiapps.framework.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [InformationEntity::class], version = 1)
abstract class InformationDatabase : RoomDatabase() {
    abstract fun informationDao(): InformationDao

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