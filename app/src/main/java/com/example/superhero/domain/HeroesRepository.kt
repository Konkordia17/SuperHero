package com.example.superhero.domain

import com.example.superhero.data.model.Hero

interface HeroesRepository {

    suspend fun getSuperheroList(): List<Hero>
}