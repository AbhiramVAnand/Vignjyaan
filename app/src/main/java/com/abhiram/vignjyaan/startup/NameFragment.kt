package com.abhiram.vignjyaan.startup

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.abhiram.vignjyaan.fragments.HomeFragment
import com.abhiram.vignjyaan.R
import com.google.android.material.button.MaterialButton

class NameFragment : Fragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_name, container, false)
        requireActivity().window.navigationBarColor = resources.getColor(R.color.white)
        val name : EditText = inflate.findViewById(R.id.student)
        val flagSp = context?.getSharedPreferences("com.abhiram.vignjyaan", Context.MODE_PRIVATE)
        val button : MaterialButton = inflate.findViewById(R.id.getstarted)
        button.setOnClickListener {
            if (name.text.toString() != "") {
                flagSp!!.edit().putString("name", name.text.toString()).apply()
                flagSp!!.edit().putInt("isfirst", 1).apply()
                val fragmentManager = parentFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentManager.popBackStack()
                fragmentTransaction.setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.exit_to_left,
                    R.anim.enter_from_left,
                    R.anim.exit_to_right
                ).replace(R.id.frag_view, HomeFragment()).commit()
            } else {
                Toast.makeText(context, "Name can't be empty", Toast.LENGTH_SHORT).show()
            }
        }
        return inflate
    }
}