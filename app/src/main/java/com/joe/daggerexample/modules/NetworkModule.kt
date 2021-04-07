package com.joe.daggerexample.modules

import android.app.Application
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule constructor(val baseUrl: String) {
    @Singleton
    @Provides
    fun provideSharedPreferences(application: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    @Singleton
    @Provides
    fun provideOkhttpCache(application: Application): Cache {
        val cacheSize: Long = 10 * 1024 * 1024 //10mb cache size
        //set it in default cache dir
        return Cache(application.cacheDir, cacheSize)
    }

    @Singleton
    @Provides
    fun provideOkhttpClient(cache: Cache): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.cache(cache)
        return clientBuilder.build()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        val retrofitBuilder = Retrofit.Builder()
        retrofitBuilder.apply {
            baseUrl(baseUrl)
            addConverterFactory(GsonConverterFactory.create(gson))
            client(okHttpClient)
        }
        return retrofitBuilder.build()
    }
}