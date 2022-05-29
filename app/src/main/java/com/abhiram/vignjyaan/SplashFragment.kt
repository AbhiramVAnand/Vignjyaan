package com.abhiram.vignjyaan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import java.util.*
import kotlin.concurrent.schedule


class SplashFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_splash, container, false)

        var fragmentManager = parentFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()

        val auth = FirebaseAuth.getInstance()
        val user = auth.currentUser
        Timer().schedule(3000) {
            if (user != null) {
                if (user.isEmailVerified) {
                    fragmentTransaction.replace(R.id.frag_view, HomeFragment()).commit()
                }else{
                    fragmentTransaction.replace(R.id.frag_view, VerificationFragment()).commit()
                }
            } else {
                fragmentTransaction.replace(R.id.frag_view, WelcomeFragment()).commit()
            }
        }
        return inflate
    }
}