package com.akiapps.frameworklib.di.module

import android.content.Context
import com.akiapps.frameworklib.InformationDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext


@Module
@InstallIn(FragmentComponent::class,ViewModelComponent::class)
object HiltProviderModule {
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): InformationDatabase {
        return InformationDatabase.getDatabase(context.applicationContext)
    }
}