package com.example.superhero.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.superhero.data.HeroesDataBase.Companion.DB_VERSION
import com.example.superhero.data.model.Converter
import com.example.superhero.data.model.Hero

@Database(entities = [Hero::class], version = DB_VERSION)
@TypeConverters(Converter::class)
abstract class HeroesDataBase : RoomDatabase() {

    abstract fun heroesDao(): HeroesDao

    companion object {
        const val DB_VERSION = 1
    }
}