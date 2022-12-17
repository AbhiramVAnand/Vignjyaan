//package com.abhiram.vignjyaan
//
//import android.os.Bundle
//import android.util.Log
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.ImageView
//import com.abhiram.vignjyaan.fragments.HomeFragment
//
//class ModulesFragment : Fragment() {
//    // TODO: Rename and change types of parameters
//    private var sub: String? = null
//    private var sem: String? = null
//    private var type: String? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            sub = it.getString("sub")
//            sem = it.getString("sem")
//            type = it.getString("type")
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        val inflate = inflater.inflate(R.layout.fragment_modules, container, false)
//        val path = "$type/$sem/$sub"
//        Log.e("sem","$path")
////        buttons
//        val back : ImageView = inflate.findViewById(R.id.backmod)
//        val m1 : Button = inflate.findViewById(R.id.mod1)
//        val m2 : Button = inflate.findViewById(R.id.mod2)
//        val m3 : Button = inflate.findViewById(R.id.mod3)
//        val m4 : Button = inflate.findViewById(R.id.mod4)
//        val m5 : Button = inflate.findViewById(R.id.mod5)
//        val oth : Button = inflate.findViewById(R.id.oth)
//
//        val fragManager = parentFragmentManager
//        val fragTransaction = fragManager.beginTransaction()
//
////        onClick
//        back.setOnClickListener {
//            fragTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view, HomeFragment()).commit()
//        }
//        m1.setOnClickListener {
//            val fragment = FilesFragment.newInstance("mod1","$sub","$sem", "$type")
//            fragTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view, fragment).addToBackStack("flow").commit()
//        }
//        m2.setOnClickListener {
//            val fragment = FilesFragment.newInstance("mod2","$sub","$sem", "$type")
//            fragTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view, fragment).addToBackStack("flow").commit()
//        }
//        m3.setOnClickListener {
//            val fragment = FilesFragment.newInstance("mod3","$sub","$sem", "$type")
//            fragTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view, fragment).addToBackStack("flow").commit()
//        }
//        m4.setOnClickListener {
//            val fragment = FilesFragment.newInstance("mod4","$sub","$sem", "$type")
//            fragTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view, fragment).addToBackStack("flow").commit()
//        }
//        m5.setOnClickListener {
//            val fragment = FilesFragment.newInstance("mod5","$sub","$sem", "$type")
//            fragTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view, fragment).addToBackStack("flow").commit()
//        }
//        oth.setOnClickListener {
//            val fragment = FilesFragment.newInstance("oth","$sub","$sem", "$type")
//            fragTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view, fragment).addToBackStack("flow").commit()
//        }
//        return inflate
//    }
//
//    companion object {
//        fun newInstance(param1: String, param2: String, param3: String) =
//            ModulesFragment().apply {
//                arguments = Bundle().apply {
//                    putString("sub", param1)
//                    putString("sem", param2)
//                    putString("type", param3)
//                }
//            }
//    }
//}