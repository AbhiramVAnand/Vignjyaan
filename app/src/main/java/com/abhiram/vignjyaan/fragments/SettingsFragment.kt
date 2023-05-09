package com.abhiram.vignjyaan.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
        val credits : MaterialButton = inflate.findViewById(R.id.credits)
        val insta : ImageView = inflate.findViewById(R.id.insta)
        val linked : ImageView = inflate.findViewById(R.id.linked)
        val fragmentManager = parentFragmentManager
        val fragTrans = fragmentManager.beginTransaction()
        requireActivity().window.navigationBarColor = resources.getColor(R.color.purpD)

        credits.setOnClickListener{
            fragTrans.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            ).replace(R.id.frag_view, CreditsFragment()).addToBackStack("credit").commit()
        }

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
        linked.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.linkedin.com/company/ece-gec-palakkad/")
            startActivity(intent)
        }
        insta.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.instagram.com/ece_gec_pkd/?igshid=ZDdkNTZiNTM%3D")
            startActivity(intent)
        }
        return inflate
    }
}