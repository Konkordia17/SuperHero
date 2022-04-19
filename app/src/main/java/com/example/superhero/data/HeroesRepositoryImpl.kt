package com.example.superhero.data

import android.util.Log
import com.example.superhero.data.model.Hero
import com.example.superhero.data.utils.Api
import com.example.superhero.domain.HeroesRepository
import javax.inject.Inject

class HeroesRepositoryImpl @Inject constructor(private val api: Api) : HeroesRepository {

    override suspend fun getSuperheroList(): List<Hero> {
        var heroesList = emptyList<Hero>()
        return try {
            for (i in 1..50) {
                val hero = api.getSuperheroList(i)
                heroesList = heroesList + listOf(hero)
            }
            heroesList
        } catch (t: Throwable) {
            Log.d("f", "${t.message}")
            emptyList()
        }
    }
}
