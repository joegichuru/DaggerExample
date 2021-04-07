package com.joe.daggerexample.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule constructor(val application: Application) {
    @Provides
    @Singleton
    fun provideApplication(): Application = application
}