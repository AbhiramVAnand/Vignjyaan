package com.abhiram.vignjyaan

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import java.util.*
import kotlin.concurrent.schedule

class WelcomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_welcome, container, false)
        val getSet : Button = inflate.findViewById(R.id.loginBtn)
        val flagSp = context?.getSharedPreferences("com.abhiram.vignjyaan", Context.MODE_PRIVATE)
        getSet.setOnClickListener(){
            flagSp!!.edit().putInt("flag",1).apply()
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frag_view, HomeFragment()).commit()
        }
        return inflate
    }

}