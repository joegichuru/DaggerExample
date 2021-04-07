package com.joe.daggerexample

import android.app.Application
import com.joe.daggerexample.components.AppComponent
import com.joe.daggerexample.components.DaggerAppComponent
import com.joe.daggerexample.modules.AppModule
import com.joe.daggerexample.modules.NetworkModule
import dagger.Component

class App : Application() {
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule("https://www.google.com"))
            .build()
    }
}