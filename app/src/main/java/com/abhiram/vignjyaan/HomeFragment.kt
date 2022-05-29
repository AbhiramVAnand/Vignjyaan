package com.abhiram.vignjyaan

import android.content.ContentValues.TAG
import android.content.Context
import android.media.Image
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
import com.google.firebase.firestore.ktx.getField
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text
import java.lang.StringBuilder
import java.util.*

import kotlin.concurrent.schedule

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
        var nameUser = context?.getSharedPreferences("com.abhiram.vignjyaan", Context.MODE_PRIVATE)
        var name = nameUser!!.getString("name"," ")
        var greetBx : TextView = inflate.findViewById(R.id.greet)
        greetBx.text = "$name,"
        var notices : TextView = inflate.findViewById(R.id.notics)
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
        var materials : ImageView = inflate.findViewById(R.id.mateb)
        var info : ImageView = inflate.findViewById(R.id.infob)
        materials.setOnClickListener(){
            fragTrans.replace(R.id.frag_view,MaterialsFragment()).commit()
        }
        info.setOnClickListener(){
            fragTrans.replace(R.id.frag_view,InfoFragment()).commit()
        }
        return inflate
    }
}