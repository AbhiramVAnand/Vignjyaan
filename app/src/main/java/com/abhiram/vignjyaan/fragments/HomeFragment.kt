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

        val test : ImageView = inflate.findViewById(R.id.test)
        val fragTrans = fragmentManager.beginTransaction()
        val flagSp = context?.getSharedPreferences("com.abhiram.vignjyaan", Context.MODE_PRIVATE)
        val name : String = flagSp!!.getString("name"," ").toString()
        val studentName : TextView = inflate.findViewById(R.id.stuname)
        studentName.text = "Hi,\n$name"
        val docRef = db.collection("Notifications").document("Notifications")
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


        test.setOnClickListener {
            fragTrans.replace(R.id.frag_view, DbFetchFragment()).addToBackStack("path").commit()
        }
        return inflate
    }
}