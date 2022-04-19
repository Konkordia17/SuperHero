package com.example.superhero.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.superhero.data.model.Hero

@Dao
interface HeroesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertHero(heroesList: List<Hero>)
}