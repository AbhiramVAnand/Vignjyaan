package com.abhiram.vignjyaan

import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class GateFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val database = FirebaseDatabase.getInstance()
        val links = StringBuilder()
        var myRef = database.getReference("Gate")
            myRef.addListenerForSingleValueEvent(
                object: ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val value = snapshot.key
                        val url = value.toString()
                        Log.e("abhiram", "Value is: " + value)
                        val pdfViewer : Intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        startActivity(pdfViewer)
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
                    }
                }
            )
        return inflater.inflate(R.layout.fragment_gate, container, false)
    }

}