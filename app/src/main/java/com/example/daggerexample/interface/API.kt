package com.example.daggerexample.`interface`

import com.example.daggerexample.model.Hero
import retrofit2.Call
import retrofit2.http.GET

interface API {


    @GET("marvel")
    fun getHeroes() : Call<List<Hero>>

}