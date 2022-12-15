//package com.abhiram.vignjyaan
//
//import android.content.Intent
//import android.net.Uri
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//
//class InfoFragment : Fragment() {
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        val inflate = inflater.inflate(R.layout.fragment_info, container, false)
//        val contact : TextView = inflate.findViewById(R.id.contact)
//        contact.setOnClickListener(){
//            val openURL = Intent(Intent.ACTION_VIEW)
//            openURL.data = Uri.parse("mailto:anandabhiram0.ar@gmail.com")
//            startActivity(openURL)
//        }
//        val connect : TextView = inflate.findViewById(R.id.link)
//        connect.setOnClickListener(){
//            val openURL = Intent(Intent.ACTION_VIEW)
//            openURL.data = Uri.parse("https://abhiramvanand.github.io/")
//            startActivity(openURL)
//        }
//        val materials : ImageView = inflate.findViewById(R.id.mateb)
//        val home : ImageView = inflate.findViewById(R.id.homeb)
//        val fragmentManager = parentFragmentManager
//        val fragTrans = fragmentManager.beginTransaction()
//        materials.setOnClickListener(){
//            fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view,MaterialsFragment()).addToBackStack("flow").commit()
//        }
//        home.setOnClickListener(){
//            fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view,HomeFragment()).addToBackStack("flow").commit()
//        }
//        return inflate
//    }
//}