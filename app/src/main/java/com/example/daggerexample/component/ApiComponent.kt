package com.example.daggerexample.component

import com.example.daggerexample.MainActivity
import com.example.daggerexample.module.APIModule
import com.example.daggerexample.module.AppModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, APIModule::class])
interface ApiComponent {
    fun inject(activity: MainActivity)
}