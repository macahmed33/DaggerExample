package com.example.daggerexample

import android.app.Application
import com.example.daggerexample.component.ApiComponent
import com.example.daggerexample.component.DaggerApiComponent

import com.example.daggerexample.module.APIModule
import com.example.daggerexample.module.AppModule

class MyApplication : Application() {

    lateinit var apiComponent : ApiComponent

    override fun onCreate() {
        super.onCreate()

        apiComponent = DaggerApiComponent.builder()
            .appModule(AppModule(this))
            .aPIModule(APIModule("https://simplifiedcoding.net/demos/"))
            .build()

    }

    fun getNetComponent() : ApiComponent{
        return apiComponent
    }

}