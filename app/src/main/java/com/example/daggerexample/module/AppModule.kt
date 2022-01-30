package com.example.daggerexample.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    lateinit var myApp : Application

    constructor(myApp: Application) {
        this.myApp = myApp
    }

    @Provides
    @Singleton
    fun provideApplication() : Application{
        return myApp
    }

}