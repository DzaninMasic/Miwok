package com.example.miwokkotlin.modules

import android.content.Context
import android.media.MediaPlayer
import com.example.miwokkotlin.CategoryView
import com.example.miwokkotlin.datasource.DataSource
import com.example.miwokkotlin.fragments.MiwokFragment
import com.example.miwokkotlin.presenters.MiwokPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.components.SingletonComponent
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ViewModule {

    @Provides
    fun provideDataSource(): DataSource{
        return DataSource()
    }

}