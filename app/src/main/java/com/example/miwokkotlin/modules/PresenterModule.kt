package com.example.miwokkotlin.modules

import com.example.miwokkotlin.datasource.DataSource
import com.example.miwokkotlin.presenters.MiwokPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object PresenterModule {

    @Provides
    fun providePresenter(dataSource: DataSource) = MiwokPresenter(dataSource)

}