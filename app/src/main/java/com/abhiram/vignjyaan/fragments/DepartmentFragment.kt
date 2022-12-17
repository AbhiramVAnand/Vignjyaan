package com.abhiram.vignjyaan.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.abhiram.vignjyaan.R

class DepartmentFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_department, container, false)
        val fragmentManager = parentFragmentManager
        val fragTrans = fragmentManager.beginTransaction()

        val mailHod : TextView = inflate.findViewById(R.id.mailhod)
        val faculties : LinearLayout = inflate.findViewById(R.id.faculty)

//  --------------mailHoD-------------
        mailHod.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:bindup@gecskp.ac.in")
            startActivity(intent)
        }
//  -------------faculties--------------
        faculties.setOnClickListener {
            fragTrans.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            ).replace(R.id.frag_view, FacultyFragment()).addToBackStack("faculty").commit()
        }
        return inflate
    }
}