package com.abhiram.vignjyaan

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView

class ModulesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var sub: String? = null
    private var path: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            sub = it.getString("sub")
            path = it.getString("path")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_modules, container, false)
        path = "$path/$sub"
        Log.e("sem","$path")
//        buttons
        val back : ImageView = inflate.findViewById(R.id.backmod)
        val m1 : Button = inflate.findViewById(R.id.mod1)
        val m2 : Button = inflate.findViewById(R.id.mod2)
        val m3 : Button = inflate.findViewById(R.id.mod3)
        val m4 : Button = inflate.findViewById(R.id.mod4)
        val m5 : Button = inflate.findViewById(R.id.mod5)

        val fragManager = parentFragmentManager
        val fragTransaction = fragManager.beginTransaction()

//        onClick
        back.setOnClickListener {
            fragTransaction.replace(R.id.frag_view, HomeFragment()).commit()
        }
        m1.setOnClickListener {
            val fragment = FilesFragment.newInstance("mod1","$path")
            fragTransaction.replace(R.id.frag_view, fragment).commit()
        }
        m2.setOnClickListener {
            val fragment = FilesFragment.newInstance("mod2","$path")
            fragTransaction.replace(R.id.frag_view, fragment).commit()
        }
        m3.setOnClickListener {
            val fragment = FilesFragment.newInstance("mod3","$path")
            fragTransaction.replace(R.id.frag_view, fragment).commit()
        }
        m4.setOnClickListener {
            val fragment = FilesFragment.newInstance("mod4","$path")
            fragTransaction.replace(R.id.frag_view, fragment).commit()
        }
        m5.setOnClickListener {
            val fragment = FilesFragment.newInstance("mod5","$path")
            fragTransaction.replace(R.id.frag_view, fragment).commit()
        }
        return inflate
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            ModulesFragment().apply {
                arguments = Bundle().apply {
                    putString("sub", param1)
                    putString("path", param2)
                }
            }
    }
}