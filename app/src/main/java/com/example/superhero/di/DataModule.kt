package com.example.superhero.di

import android.content.Context
import androidx.room.Room
import com.example.superhero.data.HeroesDao
import com.example.superhero.data.HeroesDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideChannelDao(appDatabase: HeroesDataBase): HeroesDao {
        return appDatabase.heroesDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): HeroesDataBase {
        return Room.databaseBuilder(
            appContext,
            HeroesDataBase::class.java,
            "Heroes.db"
        ).build()
    }
}