package com.abhiram.vignjyaan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class DeptFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_dept, container, false)
        val back : ImageView = inflate.findViewById(R.id.backdept)
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        back.setOnClickListener{
            fragmentTransaction.replace(R.id.frag_view,HomeFragment()).commit()
        }
        return inflate
    }
}