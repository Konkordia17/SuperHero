package com.example.superhero.domain.usecase

import com.example.superhero.data.model.Hero
import com.example.superhero.domain.HeroesRepository
import javax.inject.Inject

class GetHeroesUseCase @Inject constructor(val repository: HeroesRepository) {

    suspend fun getHeroes(): List<Hero> {
        return repository.getSuperheroList()
    }
}