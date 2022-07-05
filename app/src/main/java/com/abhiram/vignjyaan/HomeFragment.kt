package com.abhiram.vignjyaan

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.firestore.Source
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.lang.StringBuilder


class HomeFragment : Fragment() {
    val db = Firebase.firestore
    var noti : String = " "
    var notif = StringBuilder()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_home, container, false)
        val fragmentManager = parentFragmentManager
        val fragTrans = fragmentManager.beginTransaction()
//        val nameUser = context?.getSharedPreferences("com.abhiram.vignjyaan", Context.MODE_PRIVATE)
//        val name = nameUser!!.getString("name"," ")
//        val greetBx : TextView = inflate.findViewById(R.id.greet)
//        greetBx.text = "$name"
        val notices : TextView = inflate.findViewById(R.id.notics)
        val abt : TextView = inflate.findViewById(R.id.more)
        val docRef = db.collection("Notifications").document("Notifications")
        val source = Source.SERVER
        docRef.get(source).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Document found in the offline cache
                val document = task.result
                notif.append(document.get("1") as String).append("\n").append(document.get("2") as String).append("\n")
                notif.append(document.get("3") as String).append("\n").append(document.get("4") as String).append("\n")
                notif.append(document.get("5") as String)
                noti = notif.toString()
                notices.text = noti
                Log.d(TAG, "$noti",task.exception)
            } else {
                Log.e("Abhi", "Cached get failed: ")
            }
        }
        val materials : ImageView = inflate.findViewById(R.id.mateb)
        val info : ImageView = inflate.findViewById(R.id.infob)
        materials.setOnClickListener(){
            fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view,MaterialsFragment()).addToBackStack("flow").commit()
        }
        info.setOnClickListener(){
            fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view,InfoFragment()).addToBackStack("flow").commit()
        }
        abt.setOnClickListener {
            fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view,DeptFragment()).addToBackStack("flow").commit()
        }
        return inflate
    }
}