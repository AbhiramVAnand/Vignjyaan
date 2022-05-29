package com.abhiram.vignjyaan

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        var fragmentManager = supportFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frag_view, SplashFragment()).commit()
    }
}