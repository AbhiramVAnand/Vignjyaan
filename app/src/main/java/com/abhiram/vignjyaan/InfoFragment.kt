package com.abhiram.vignjyaan

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_info, container, false)
        val contact : TextView = inflate.findViewById(R.id.contact)
        contact.setOnClickListener(){
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("mailto:anandabhiram0.ar@gmail.com")
            startActivity(openURL)
        }
        var materials : ImageView = inflate.findViewById(R.id.mateb)
        var home : ImageView = inflate.findViewById(R.id.homeb)
        val fragmentManager = parentFragmentManager
        val fragTrans = fragmentManager.beginTransaction()
        materials.setOnClickListener(){
            fragTrans.replace(R.id.frag_view,MaterialsFragment()).commit()
        }
        home.setOnClickListener(){
            fragTrans.replace(R.id.frag_view,HomeFragment()).commit()
        }
        return inflate
    }
}