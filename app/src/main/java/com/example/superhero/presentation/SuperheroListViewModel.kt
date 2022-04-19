package com.example.superhero.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superhero.data.model.Hero
import com.example.superhero.domain.usecase.GetHeroesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SuperheroListViewModel @Inject constructor(private val useCase: GetHeroesUseCase) :
    ViewModel() {
    private val heroesLiveData = MutableLiveData<List<Hero>>()
    val heroes: LiveData<List<Hero>>
        get() = heroesLiveData

    fun getListHeroes(): List<Hero>? {
        viewModelScope.launch {
            heroesLiveData.value = useCase.getHeroes()
        }
        return heroesLiveData.value
    }

    fun changeList(universal: String) {
        var newList: List<Hero> = emptyList()
        if (universal == "All Universals") {
            getListHeroes()?.let { newList = it }
        } else {
            getListHeroes()?.let {
                it.forEach { hero ->
                    if (hero.biography?.publisher == universal) {
                        newList = newList + listOf(hero)
                    }
                }
            }
        }
        heroesLiveData.value = newList
    }
}
