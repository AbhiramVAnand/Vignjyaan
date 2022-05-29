package com.abhiram.vignjyaan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class SyllabusFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_syllabus, container, false)
        val fragmentManager = parentFragmentManager
        val fragTrans = fragmentManager.beginTransaction()
        val back : ImageView = inflate.findViewById(R.id.back)

        back.setOnClickListener{
            fragTrans.replace(R.id.frag_view, HomeFragment()).commit()
        }
        return inflate
    }
}