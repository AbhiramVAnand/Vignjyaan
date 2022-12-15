//package com.abhiram.vignjyaan
//
//import android.content.ContentValues
//import android.content.Context
//import android.content.Intent
//import android.net.Uri
//import android.os.Bundle
//import android.util.Log
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import com.google.firebase.database.DataSnapshot
//import com.google.firebase.database.DatabaseError
//import com.google.firebase.database.ValueEventListener
//import com.google.firebase.database.ktx.database
//import com.google.firebase.ktx.Firebase
//
//class MaterialsFragment : Fragment() {
//    private var database = Firebase.database
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        val inflate = inflater.inflate(R.layout.fragment_materials, container, false)
//        val fragmentManager = parentFragmentManager
//        val fragTrans = fragmentManager.beginTransaction()
//        val back : ImageView = inflate.findViewById(R.id.back)
//        val syllabus : ImageView = inflate.findViewById(R.id.syllabus)
//        val gate : ImageView = inflate.findViewById(R.id.gate)
//        val textbook : ImageView = inflate.findViewById(R.id.textbook)
//        val qpaper : ImageView = inflate.findViewById(R.id.qpaper)
//        val notes : ImageView = inflate.findViewById(R.id.notes)
//        var nameUser = context?.getSharedPreferences("com.abhiram.vignjyaan", Context.MODE_PRIVATE)
//        var sem = nameUser!!.getString("semester"," ")
//        gate.setOnClickListener(){
//            val fragment = FilesFragment.newInstance("", "","","Gate")
//            fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view, fragment).addToBackStack("flow").commit()
//        }
//        notes.setOnClickListener(){
//            val fragment = SemesterFragment.newInstance("Notes")
//            fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view, fragment).addToBackStack("flow").commit()
//        }
//        syllabus.setOnClickListener(){
//            val fragment = SemesterFragment.newInstance("Syllabus")
//            fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view, fragment).addToBackStack("flow").commit()
//        }
//        textbook.setOnClickListener(){
//            val fragment = SemesterFragment.newInstance("TextBooks")
//            fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view, fragment).addToBackStack("flow").commit()
//        }
//        qpaper.setOnClickListener(){
//            val fragment = SemesterFragment.newInstance("Previous")
//            fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view, fragment).addToBackStack("flow").commit()
//        }
//        back.setOnClickListener{
//            fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view, HomeFragment()).addToBackStack("flow").commit()
//        }
//        return inflate
//    }
//}