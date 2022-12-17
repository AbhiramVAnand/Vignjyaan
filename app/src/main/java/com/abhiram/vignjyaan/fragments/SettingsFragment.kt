package com.abhiram.vignjyaan.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.abhiram.vignjyaan.R
import com.google.android.material.button.MaterialButton


class SettingsFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate : View = inflater.inflate(R.layout.fragment_settings, container, false)
        val change : MaterialButton = inflate.findViewById(R.id.namechange)
        val contact : MaterialButton = inflate.findViewById(R.id.contactdev)
        val fragmentManager = parentFragmentManager
        val fragTrans = fragmentManager.beginTransaction()
        requireActivity().window.navigationBarColor = resources.getColor(R.color.purpD)

        change.setOnClickListener{
            fragTrans.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            ).replace(R.id.frag_view, ChangeNameFragment()).addToBackStack("change").commit()
        }
        contact.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:anandabhiram0.ar@gmail.com")
            startActivity(intent)
        }
        return inflate
    }
}