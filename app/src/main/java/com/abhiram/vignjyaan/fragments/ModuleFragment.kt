package com.abhiram.vignjyaan.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abhiram.vignjyaan.R
import com.abhiram.vignjyaan.adapters.CardAdapter
import com.abhiram.vignjyaan.adapters.ModuleAdapter


class ModuleFragment : Fragment() {
    private var type: String? = null
    private var subcode: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            type = it.getString("type")
            subcode = it.getString("subcode")
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_module, container, false)
        val fragTrans = parentFragmentManager.beginTransaction()
        var recyclerview : RecyclerView = inflate.findViewById(R.id.moduleRV)
        recyclerview.layoutManager = LinearLayoutManager(context)
        var adapter = context?.let { ModuleAdapter(it,type.toString(),subcode.toString(),fragTrans) }
        recyclerview.adapter = adapter
        return inflate
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            ModuleFragment().apply {
                arguments = Bundle().apply {
                    putString("type", param1)
                    putString("subcode", param2)
                }
            }
    }
}