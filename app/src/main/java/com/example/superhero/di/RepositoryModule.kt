package com.example.superhero.di

import com.example.superhero.data.HeroesRepositoryImpl
import com.example.superhero.domain.HeroesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsNewsRepository(newsRepository: HeroesRepositoryImpl): HeroesRepository
}