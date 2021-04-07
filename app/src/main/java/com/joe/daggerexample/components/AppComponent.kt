package com.joe.daggerexample.components

import com.joe.daggerexample.modules.AppModule
import com.joe.daggerexample.modules.NetworkModule
import com.joe.daggerexample.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity):Unit
}