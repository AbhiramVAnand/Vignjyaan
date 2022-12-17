package com.abhiram.vignjyaan.startup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abhiram.vignjyaan.R

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