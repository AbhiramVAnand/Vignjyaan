package com.abhiram.vignjyaan.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abhiram.vignjyaan.R


class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate : View = inflater.inflate(R.layout.fragment_settings, container, false)
        requireActivity().window.navigationBarColor = resources.getColor(R.color.purpD)
        return inflate
    }
}