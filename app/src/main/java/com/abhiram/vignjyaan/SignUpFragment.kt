package com.abhiram.vignjyaan

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import java.util.*


class SignUpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,

        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_sign_up, container, false)
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        var auth: FirebaseAuth = FirebaseAuth.getInstance()
        val sem : EditText = inflate.findViewById(R.id.semester)
        val logTxt : TextView = inflate.findViewById(R.id.signTxt)
        var email : EditText = inflate.findViewById(R.id.email)
        var signUpBtn : Button = inflate.findViewById(R.id.signin)
        var nameUsr : EditText = inflate.findViewById(R.id.name)
        var pref = context?.getSharedPreferences("com.abhiram.vignjyaan", Context.MODE_PRIVATE)
        var semm = sem.toString().lowercase()
        pref!!.edit().putString("semester", semm).apply()
        val pass = "AbhiKing"


        signUpBtn.setOnClickListener {
            var emailID = email.text.toString().lowercase()
            val usrName = nameUsr.text.toString().lowercase()
            if(emailID==" "){
                Toast.makeText(context,"Enter Mail ID!",Toast.LENGTH_LONG).show()
            }else if(usrName==" "){
                Toast.makeText(context,"Name can't be empty!",Toast.LENGTH_LONG).show()
            }else if(emailID != " ") {
                auth.createUserWithEmailAndPassword(emailID, pass).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        if (user != null) {
                            user.sendEmailVerification().addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    Toast.makeText(context,"Verification Mail Send!\nVerify and login", Toast.LENGTH_LONG).show()
                                }else{
                                    Toast.makeText(context,"Can't Send Verification Mail!", Toast.LENGTH_LONG).show()
                                }
                            }
                        }
                    }else{
                        Toast.makeText(context,"Account Already Exists\nPlease Verify Email and Login!", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        logTxt.setOnClickListener{
            fragmentTransaction.replace(R.id.frag_view,LoginFragment()).commit()
        }
        return inflate
    }
}

