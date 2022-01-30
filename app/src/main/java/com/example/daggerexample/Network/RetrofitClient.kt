package com.example.daggerexample.Network

import com.example.daggerexample.`interface`.API
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {

    private val BASE_URL = "https://simplifiedcoding.net/demos/"
    var instance: RetrofitClient? = null
    private var myApi: API? = null


    /*private fun RetrofitClient() {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        myApi = retrofit.create(API::class.java)
    }*/

    companion object {

        private val BASE_URL = "https://simplifiedcoding.net/demos/"

        fun create() : API {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(API::class.java)

        }
    }
}

    /*@Synchronized
    fun instance(): RetrofitClient? {
        if (instance == null) {
            instance = RetrofitClient()
        }
        return instance
    }

    fun getMyApi(): API? {
        return myApi
    }*/

//}