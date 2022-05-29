package com.abhiram.vignjyaan

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SemesterFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_semester, container, false)
        val semSub : Button= inflate.findViewById(R.id.semSub)
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val semVal : EditText = inflate.findViewById(R.id.semT)
        var semm = semVal.toString().lowercase()
        var nameUser = context?.getSharedPreferences("com.abhiram.vignjyaan", Context.MODE_PRIVATE)
        if(semm!=" "){
            nameUser!!.edit().putString("semester", semm).apply()
            fragmentTransaction.replace(R.id.frag_view,HomeFragment()).commit()
        }else{
            Toast.makeText(context,"Enter Semester!",Toast.LENGTH_LONG).show()
        }
        return inflate
    }
}