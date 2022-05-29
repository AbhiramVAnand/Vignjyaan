package com.abhiram.vignjyaan

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsClient.getPackageName
import androidx.fragment.app.Fragment
import com.google.firebase.auth.ActionCodeSettings
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.actionCodeSettings


class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_login, container, false)
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val signTxt : TextView = inflate.findViewById(R.id.logTxt)
        var auth: FirebaseAuth = FirebaseAuth.getInstance()
        var email : EditText = inflate.findViewById(R.id.email)
        var loginBtn : Button = inflate.findViewById(R.id.login)
        var nameUsr : EditText = inflate.findViewById(R.id.name)
        val pass = "AbhiKing"
        val nameUser = context?.getSharedPreferences("com.abhiram.vignjyaan", Context.MODE_PRIVATE)
        var sem = nameUser!!.getString("semester"," ")


        loginBtn.setOnClickListener {
            var emailID = email.text.toString().lowercase()
            val usrName = nameUsr.text.toString().lowercase()
            if(emailID==" "){
                Toast.makeText(context,"Enter Mail ID!",Toast.LENGTH_LONG).show()
            }else if(usrName==" "){
                Toast.makeText(context,"Name can't be empty!",Toast.LENGTH_LONG).show()
            }
            if(emailID != " " && usrName != " ") {
                val len: Int = emailID.length
                val check: CharSequence = emailID.substring(len - 12, len)
                nameUser!!.edit().putString("name",usrName).apply()
                if (check == "gecskp.ac.in") {
                    auth.signInWithEmailAndPassword(emailID, pass).addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(context , "Login Successfull!\nWelcome $usrName", Toast.LENGTH_SHORT).show()
                            }else{
                                Toast.makeText(context , "Login Failed!\nE-mail Incorrect", Toast.LENGTH_SHORT).show()
                            }
                    }
                    if(sem!=" ") {
                        fragmentTransaction.replace(R.id.frag_view, HomeFragment()).commit()
                    }else{
                        fragmentTransaction.replace(R.id.frag_view, SemesterFragment()).commit()
                    }
                } else {
                    Toast.makeText(context , "Use College Mail", Toast.LENGTH_SHORT).show()
                }
            }
        }
        signTxt.setOnClickListener{
            fragmentTransaction.replace(R.id.frag_view,SignUpFragment()).commit()
        }
        return inflate
    }
}