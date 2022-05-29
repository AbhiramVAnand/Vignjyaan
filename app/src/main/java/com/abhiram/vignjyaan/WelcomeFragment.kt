package com.abhiram.vignjyaan

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

        getSet.setOnClickListener(){
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frag_view, LoginFragment()).commit()
        }
        return inflate
    }

}