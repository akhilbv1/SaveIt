package com.akiapps.frameworklib.di.module

import android.content.Context
import com.akiapps.frameworklib.InformationDatabase
import com.akiapps.frameworklib.Repository
import com.akiapps.frameworklib.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(FragmentComponent::class,ViewModelComponent::class)
abstract class HiltModule {
    @Binds
    abstract fun bindRepository(
        repositoryImpl: RepositoryImpl
    ): Repository
}