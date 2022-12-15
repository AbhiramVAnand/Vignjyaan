package com.abhiram.vignjyaan.startup

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abhiram.vignjyaan.fragments.HomeFragment
import com.abhiram.vignjyaan.R
import java.util.*
import kotlin.concurrent.schedule


class SplashFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_splash, container, false)
        requireActivity().window.navigationBarColor = resources.getColor(R.color.purpD)
        var fragmentManager = parentFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()
        val flagSp = context?.getSharedPreferences("com.abhiram.vignjyaan", Context.MODE_PRIVATE)
        val flag = flagSp!!.getInt("isfirst",0)
        Timer().schedule(3000) {
            if (flag==1) {
                fragmentTransaction.setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.exit_to_left,
                    R.anim.enter_from_left,
                    R.anim.exit_to_right
                ).replace(R.id.frag_view, HomeFragment()).commit()
            } else {
                fragmentTransaction.setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.exit_to_left,
                    R.anim.enter_from_left,
                    R.anim.exit_to_right
                ).replace(R.id.frag_view, WelcomeFragment()).commit()
            }
        }
        return inflate
    }
}