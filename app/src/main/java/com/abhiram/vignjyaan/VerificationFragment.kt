package com.abhiram.vignjyaan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class VerificationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_verification, container, false)
        val auth = FirebaseAuth.getInstance()
        val user = auth.currentUser
        if(user!=null){
            parentFragmentManager.beginTransaction().replace(R.id.frag_view,LoginFragment()).commit()
        }else{
            Toast.makeText(context,"Verification Email Sent\nPlease Verify Email First!", Toast.LENGTH_LONG).show()
        }
        return inflate
    }

}