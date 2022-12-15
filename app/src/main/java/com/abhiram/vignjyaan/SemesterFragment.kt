package com.abhiram.vignjyaan

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.abhiram.vignjyaan.fragments.HomeFragment


class SemesterFragment : Fragment() {
    private var mat : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mat = it.getString("type")
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_semester, container, false)
        val type : TextView = inflate.findViewById(R.id.type)
        val fragmentManager = parentFragmentManager
        val fragTrans = fragmentManager.beginTransaction()
        val back : ImageView = inflate.findViewById(R.id.back)
        Log.e("","values: $mat")
        type.text = mat.toString()
        back.setOnClickListener{
            fragTrans.replace(R.id.frag_view, HomeFragment()).commit()
        }
//        start
        val s1 : Button = inflate.findViewById(R.id.s1)
        val s2 : Button = inflate.findViewById(R.id.s2)
        val s3 : Button = inflate.findViewById(R.id.s3)
        val s4 : Button = inflate.findViewById(R.id.s4)
        val s5 : Button = inflate.findViewById(R.id.s5)
        val s6 : Button = inflate.findViewById(R.id.s6)

        s1.setOnClickListener(){
            val fragment = SubjectFragment.newInstance("S1","$mat")
            fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view, fragment).addToBackStack("flow").commit()
        }
        s2.setOnClickListener(){
            val fragment = SubjectFragment.newInstance("S2","$mat")
            fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view, fragment).addToBackStack("flow").commit()
        }
        s3.setOnClickListener(){
            val fragment = SubjectFragment.newInstance("S3","$mat")
            fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view, fragment).addToBackStack("flow").commit()
        }
        s4.setOnClickListener(){
            val fragment = SubjectFragment.newInstance("S4","$mat")
            fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view, fragment).addToBackStack("flow").commit()
        }
        s5.setOnClickListener(){
            val fragment = SubjectFragment.newInstance("S5","$mat")
            fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view, fragment).addToBackStack("flow").commit()
        }
        s6.setOnClickListener(){
            val fragment = SubjectFragment.newInstance("S6","$mat")
            fragTrans.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right).replace(R.id.frag_view, fragment).addToBackStack("flow").commit()
        }
//        end
        return inflate
    }
    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            SemesterFragment().apply {
                arguments = Bundle().apply {
                    putString("type", param1)
                }
            }
    }
}