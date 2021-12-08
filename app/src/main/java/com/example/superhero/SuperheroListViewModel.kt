package com.example.superhero

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SuperheroListViewModel : ViewModel() {
    private val heroesLiveData = MutableLiveData<List<Hero>>()
    private var heroesList = emptyList<Hero>()
    val heroes: LiveData<List<Hero>>
        get() = heroesLiveData

    fun getListHeroes() {
        viewModelScope.launch {
            try {
                for (i in 1..50) {
                    val hero = Networking.api.getSuperheroList(i)
                    heroesList = heroesList + listOf(hero)
                }
                heroesLiveData.value = heroesList
            } catch (t: Throwable) {
                Log.d("f", "${t.message}")
            }
        }
    }

    fun changeList(universal: String) {
        var newList: List<Hero> = emptyList()
        if (universal == "All Universals") {
            newList = heroesList
        } else {
            heroesList.forEach {
                if (it.biography?.publisher == universal) {
                    newList = newList + listOf(it)
                }
            }
        }
        heroesLiveData.value = newList
    }
}
