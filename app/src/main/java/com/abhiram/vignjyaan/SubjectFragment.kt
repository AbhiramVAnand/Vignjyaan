package com.abhiram.vignjyaan

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.firestore.Source
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


/**
 * A simple [Fragment] subclass.
 * Use the [SubjectFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SubjectFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var sem: String? = null
    private var type: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            sem = it.getString("sem")
            type = it.getString("type")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_subject, container, false)
        val fragManager = parentFragmentManager
        val fragTrans = fragManager.beginTransaction()
        var sub1 : String? = null
        var sub2 : String? = null
        var sub3 : String? = null
        var sub4 : String? = null
        var sub5 : String? = null
        var sub6 : String? = null
        val s1b : Button = inflate.findViewById(R.id.sub1)
        val s2b : Button = inflate.findViewById(R.id.sub2)
        val s3b : Button = inflate.findViewById(R.id.sub3)
        val s4b : Button = inflate.findViewById(R.id.sub4)
        val s5b : Button = inflate.findViewById(R.id.sub5)
        val s6b : Button = inflate.findViewById(R.id.sub6)
        val babu : ImageView = inflate.findViewById(R.id.backbu)
        val sembx : TextView = inflate.findViewById(R.id.sem)
        Log.e("sem","$type/$sem")
        sembx.text = sem.toString()
        val db = Firebase.firestore
        val docRef = db.collection("subjects").document("$sem")
        val source = Source.SERVER
        docRef.get(source).addOnCompleteListener{ task->
            if (task.isSuccessful) {
                val document = task.result
                 sub1 = document.get("1") as String
                Log.e("sunb","$sub1")
                 sub2 = document.get("2") as String
                 sub3 = document.get("3") as String
                 sub4 = document.get("4") as String
                 sub5 = document.get("5") as String
                 sub6 = document.get("6") as String
                s1b.text = sub1
                s2b.text = sub2
                s3b.text = sub3
                s4b.text = sub4
                s5b.text = sub5
                s6b.text = sub6
            } else {
                Log.e("Abhi", "Cached get failed: ")
            }
        }
        babu.setOnClickListener{
            fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view, HomeFragment()).commit()
        }
        if(type=="Syllabus"){
            s1b.setOnClickListener {
                val fragment = FilesFragment.newInstance("","$sub1","$sem","$type")
                fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view,fragment).addToBackStack("flow").commit()
            }
            s6b.setOnClickListener {
                val fragment = FilesFragment.newInstance("","$sub6","$sem","$type")
                fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view,fragment).addToBackStack("flow").commit()
            }
            s2b.setOnClickListener {
                val fragment = FilesFragment.newInstance("","$sub2","$sem","$type")
                fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view,fragment).addToBackStack("flow").commit()
            }
            s3b.setOnClickListener {
                val fragment = FilesFragment.newInstance("","$sub3","$sem","$type")
                fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view,fragment).addToBackStack("flow").commit()
            }
            s4b.setOnClickListener {
                val fragment = FilesFragment.newInstance("","$sub4","$sem","$type")
                fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view,fragment).addToBackStack("flow").commit()
            }
            s5b.setOnClickListener {
                val fragment = FilesFragment.newInstance("","$sub5","$sem","$type")
                fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view,fragment).addToBackStack("path").commit()
            }
        }else {
            s1b.setOnClickListener {
                val fragment = ModulesFragment.newInstance("$sub1", "$sem", "$type")
                fragTrans.setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.exit_to_left,
                    R.anim.enter_from_left,
                    R.anim.exit_to_right
                ).replace(R.id.frag_view, fragment).addToBackStack("flow").commit()
            }
            s6b.setOnClickListener {
                val fragment = ModulesFragment.newInstance("$sub6", "$sem", "$type")
                fragTrans.setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.exit_to_left,
                    R.anim.enter_from_left,
                    R.anim.exit_to_right
                ).replace(R.id.frag_view, fragment).addToBackStack("flow").commit()
            }
            s2b.setOnClickListener {
                val fragment = ModulesFragment.newInstance("$sub2", "$sem", "$type")
                fragTrans.setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.exit_to_left,
                    R.anim.enter_from_left,
                    R.anim.exit_to_right
                ).replace(R.id.frag_view, fragment).addToBackStack("flow").commit()
            }
            s3b.setOnClickListener {
                val fragment = ModulesFragment.newInstance("$sub3", "$sem", "$type")
                fragTrans.setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.exit_to_left,
                    R.anim.enter_from_left,
                    R.anim.exit_to_right
                ).replace(R.id.frag_view, fragment).addToBackStack("flow").commit()
            }
            s4b.setOnClickListener {
                val fragment = ModulesFragment.newInstance("$sub4", "$sem", "$type")
                fragTrans.setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.exit_to_left,
                    R.anim.enter_from_left,
                    R.anim.exit_to_right
                ).replace(R.id.frag_view, fragment).addToBackStack("flow").commit()
            }
            s5b.setOnClickListener {
                val fragment = ModulesFragment.newInstance("$sub5", "$sem", "$type")
                fragTrans.setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.exit_to_left,
                    R.anim.enter_from_left,
                    R.anim.exit_to_right
                ).replace(R.id.frag_view, fragment).addToBackStack("path").commit()
            }
        }
        // Inflate the layout for this fragment
        return inflate
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String,param2: String) =
            SubjectFragment().apply {
                arguments = Bundle().apply {
                    putString("sem", param1)
                    putString("type", param2)
                }
            }
    }
}