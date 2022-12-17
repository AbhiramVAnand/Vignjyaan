package com.abhiram.vignjyaan.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.abhiram.vignjyaan.R


class SemesterFragment : Fragment() {
    private var type: String? = null
    private lateinit var fragment: SubjectFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            type = it.getString("type")
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_semester, container, false)
        requireActivity().window.navigationBarColor = resources.getColor(R.color.purpD)
        val FragTrans = parentFragmentManager.beginTransaction()

        val s1 : ImageView = inflate.findViewById(R.id.s1)
        val s2 : ImageView = inflate.findViewById(R.id.s2)
        val s3 : ImageView = inflate.findViewById(R.id.s3)
        val s4 : ImageView = inflate.findViewById(R.id.s4)
        val s5 : ImageView = inflate.findViewById(R.id.s5)
        val s6 : ImageView = inflate.findViewById(R.id.s6)
        val s7 : ImageView = inflate.findViewById(R.id.s7)
        val s8 : ImageView = inflate.findViewById(R.id.s8)

        s1.setOnClickListener {
            fragment = SubjectFragment.newInstance(type.toString(),1)
            FragTrans.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            ).replace(R.id.frag_view, fragment).addToBackStack("path").commit()
        }
        s2.setOnClickListener {
            fragment = SubjectFragment.newInstance(type.toString(),2)
            FragTrans.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            ).replace(R.id.frag_view, fragment).addToBackStack("path").commit()
        }
        s3.setOnClickListener {
            fragment = SubjectFragment.newInstance(type.toString(),3)
            FragTrans.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            ).replace(R.id.frag_view, fragment).addToBackStack("path").commit()
        }
        s4.setOnClickListener {
            fragment = SubjectFragment.newInstance(type.toString(),4)
            FragTrans.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            ).replace(R.id.frag_view, fragment).addToBackStack("path").commit()
        }
        s5.setOnClickListener {
            fragment = SubjectFragment.newInstance(type.toString(),5)
            FragTrans.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            ).replace(R.id.frag_view, fragment).addToBackStack("path").commit()
        }
        s6.setOnClickListener {
            fragment = SubjectFragment.newInstance(type.toString(),6)
            FragTrans.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            ).replace(R.id.frag_view, fragment).addToBackStack("path").commit()
        }
        s7.setOnClickListener {
            fragment = SubjectFragment.newInstance(type.toString(),7)
            FragTrans.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            ).replace(R.id.frag_view, fragment).addToBackStack("path").commit()
        }
        s8.setOnClickListener {
            fragment = SubjectFragment.newInstance(type.toString(),8)
            FragTrans.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            ).replace(R.id.frag_view, fragment).addToBackStack("path").commit()
        }
        return inflate
    }

    companion object {
        @JvmStatic
        fun newInstance(type: String) =
            SemesterFragment().apply {
                arguments = Bundle().apply {
                    putString("type", type)
                }
            }
    }
}