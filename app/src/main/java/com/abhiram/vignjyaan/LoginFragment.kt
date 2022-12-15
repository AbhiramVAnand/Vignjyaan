//package com.abhiram.vignjyaan
//
//import android.content.Context
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
//import android.widget.Toast
//import androidx.fragment.app.Fragment
//import com.google.firebase.auth.FirebaseAuth
//
//
//class LoginFragment : Fragment() {
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val inflate = inflater.inflate(R.layout.fragment_login, container, false)
//        val fragmentManager = parentFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        val signTxt : TextView = inflate.findViewById(R.id.logTxt)
//        val auth: FirebaseAuth = FirebaseAuth.getInstance()
//        val email : EditText = inflate.findViewById(R.id.email)
//        val loginBtn : Button = inflate.findViewById(R.id.login)
//        val nameUsr : EditText = inflate.findViewById(R.id.name)
//        val pass = "AbhiKing"
//        val nameUser = context?.getSharedPreferences("com.abhiram.vignjyaan", Context.MODE_PRIVATE)
//        var sem = nameUser!!.getString("semester"," ")
//
//
//        loginBtn.setOnClickListener {
//            val emailID = email.text.toString().lowercase()
//            val usrName = nameUsr.text.toString().lowercase()
//            if(emailID==" "){
//                Toast.makeText(context,"Enter Mail ID!",Toast.LENGTH_LONG).show()
//            }else if(usrName==" "){
//                Toast.makeText(context,"Name can't be empty!",Toast.LENGTH_LONG).show()
//            }
//            if(emailID != " " && usrName != " ") {
//                nameUser.edit().putString("name",usrName).apply()
//                auth.signInWithEmailAndPassword(emailID, pass).addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        fragmentTransaction.replace(R.id.frag_view,HomeFragment()).commit()
//                        Toast.makeText(context , "Login Successfull!\nWelcome $usrName", Toast.LENGTH_SHORT).show()
//                    }else{
//                        Toast.makeText(context , "Login Failed!\nE-mail Incorrect", Toast.LENGTH_SHORT).show()
//                    }
//                }
//            }
//        }
//        signTxt.setOnClickListener{
//            fragmentTransaction.replace(R.id.frag_view,SignUpFragment()).commit()
//        }
//        return inflate
//    }
//}