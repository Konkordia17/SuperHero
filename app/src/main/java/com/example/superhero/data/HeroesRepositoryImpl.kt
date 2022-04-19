package com.example.superhero.data

import android.util.Log
import com.example.superhero.data.model.Hero
import com.example.superhero.data.utils.Api
import com.example.superhero.domain.HeroesRepository
import javax.inject.Inject

class HeroesRepositoryImpl @Inject constructor(
    private val api: Api,
    private val heroesDB: HeroesDataBase
) : HeroesRepository {

    override suspend fun getSuperheroList(): List<Hero> {
        var heroesList = emptyList<Hero>()
        try {
            for (i in 1..50) {
                val hero = api.getSuperheroList(i)
                heroesList = heroesList + listOf(hero)
                heroesDB.heroesDao().insertHero(heroesList)
            }

        } catch (t: Throwable) {
            Log.d("f", "${t.message}")
        }
        return heroesList
    }
}
