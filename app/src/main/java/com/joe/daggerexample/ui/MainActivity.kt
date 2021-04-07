package com.joe.daggerexample.ui

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.joe.daggerexample.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var mainBiding: ActivityMainBinding
    @Inject lateinit var sharedPreferences:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBiding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBiding.root)

    }
}