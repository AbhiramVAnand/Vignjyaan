package com.abhiram.vignjyaan.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.abhiram.vignjyaan.R
import com.google.android.material.button.MaterialButton
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.lang.StringBuilder


class HomeFragment : Fragment() {
    val db = Firebase.firestore
    var noti : String = " "
    var notif = StringBuilder()
    var i : Int = 0
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_home, container, false)
        requireActivity().window.navigationBarColor = resources.getColor(R.color.white)
        val fragmentManager = parentFragmentManager
        val fragTrans = fragmentManager.beginTransaction()
//--------------Buttons-------------------
        val note : ImageView = inflate.findViewById(R.id.note)
        val syllabus : ImageView = inflate.findViewById(R.id.sylbs)
        val text : ImageView = inflate.findViewById(R.id.tbooks)
        val prev : ImageView = inflate.findViewById(R.id.prev)
        val dept : ImageView = inflate.findViewById(R.id.dept)
        val others : ImageView = inflate.findViewById(R.id.others)
        val settings : MaterialButton = inflate.findViewById(R.id.settings)

// --------------------------------------------

//---------------Print name-------------------
        val flagSp = context?.getSharedPreferences("com.abhiram.vignjyaan", Context.MODE_PRIVATE)
        val name : String = flagSp!!.getString("name"," ").toString()
        val studentName : TextView = inflate.findViewById(R.id.stuname)
        studentName.text = "Hi,\n$name"
// ------------------------------------------

//  -------------Settings-------------
        settings.setOnClickListener{
            fragTrans.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            ).replace(R.id.frag_view, SettingsFragment()).addToBackStack("path").commit()
        }
//  -------------dept.-------------
        dept.setOnClickListener {
            fragTrans.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            ).replace(R.id.frag_view, DepartmentFragment()).addToBackStack("path").commit()
        }
//  -------------others------------
//        https://pdfhost.io/edit?doc=b3262456-5779-4fa3-8343-265c1e7e92ea
        others.setOnClickListener {
            fragTrans.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            ).replace(R.id.frag_view, OthersFragment()).addToBackStack("path").commit()
        }
//  -------------Notes-------------
        note.setOnClickListener {
            val fragment = SemesterFragment.newInstance("Note")
            fragTrans.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            ).replace(R.id.frag_view, fragment).addToBackStack("path").commit()
        }
//  -------------Syllabus-------------
        syllabus.setOnClickListener {
            val fragment = SemesterFragment.newInstance("Syllabus")
            fragTrans.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            ).replace(R.id.frag_view, fragment).addToBackStack("path").commit()
        }
//  -------------Previous-------------
        prev.setOnClickListener {
            val fragment = SemesterFragment.newInstance("Previous")
            fragTrans.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            ).replace(R.id.frag_view, fragment).addToBackStack("path").commit()
        }
//  -------------Text-------------
        text.setOnClickListener {
            val fragment = SemesterFragment.newInstance("Textbook")
            fragTrans.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            ).replace(R.id.frag_view, fragment).addToBackStack("path").commit()
        }
        return inflate
    }
}

//        val source = Source.SERVER
//            docRef.get(source).addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    // Document found in the offline cache
//                    val document = task.result
//                    notif.append(document.get("1") as String).append("\n")
//                        .append(document.get("2") as String).append("\n")
//                    notif.append(document.get("3") as String).append("\n")
//                        .append(document.get("4") as String).append("\n")
//                    notif.append(document.get("5") as String)
//                    noti = notif.toString()
//                    notif.clear()
//                    i += 1
//                    Log.d(TAG, "$noti \n,$i", task.exception)
//                } else {
//                    Log.e("Abhi", "Cached get failed: ")
//                }
//            }