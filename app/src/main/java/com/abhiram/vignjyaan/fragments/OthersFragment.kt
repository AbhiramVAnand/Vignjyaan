package com.abhiram.vignjyaan.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.abhiram.vignjyaan.R

class OthersFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_others, container, false)
        requireActivity().window.navigationBarColor = resources.getColor(R.color.purpD)
        val fragTrans = parentFragmentManager.beginTransaction()
        val gate : TextView = inflate.findViewById(R.id.gate)
        val apti : TextView = inflate.findViewById(R.id.apti)

        gate.setOnClickListener {
            fragTrans.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            ).replace(R.id.frag_view, GateFragment()).addToBackStack("gate").commit()
        }
        apti.setOnClickListener {
            val link: String = "https://drive.google.com/file/d/1pWcBN0YgGY7spvyRRS9eKA1tOmx-PS-_/view?usp=share_link"
            val pdfViewer : Intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(pdfViewer)
        }
        return inflate
    }
}