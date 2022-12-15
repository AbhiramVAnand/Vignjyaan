package com.abhiram.vignjyaan.startup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.abhiram.vignjyaan.R

class WelcomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_welcome, container, false)
        val getSet : Button = inflate.findViewById(R.id.loginBtn)
        requireActivity().window.navigationBarColor = resources.getColor(R.color.white)
        getSet.setOnClickListener(){
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            ).replace(R.id.frag_view, NameFragment()).addToBackStack("startup").commit()
        }
        return inflate
    }

}