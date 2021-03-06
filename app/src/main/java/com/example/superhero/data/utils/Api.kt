package com.example.superhero.data.utils

import com.example.superhero.data.model.Hero
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("api.php/1906623662850017/{id}")
    suspend fun getSuperheroList(@Path("id") id: Int): Hero
}