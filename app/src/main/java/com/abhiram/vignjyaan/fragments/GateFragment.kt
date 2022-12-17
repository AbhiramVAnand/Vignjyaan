package com.abhiram.vignjyaan.fragments

import android.os.Bundle
import android.provider.Settings.Global
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abhiram.vignjyaan.R
import com.abhiram.vignjyaan.adapters.CardAdapter
import com.abhiram.vignjyaan.adapters.FacultyAdapter
import com.abhiram.vignjyaan.database.AppDatabase
import com.abhiram.vignjyaan.database.MaterialsList
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GateFragment : Fragment() {
    private var files : MutableList<MaterialsList> = ArrayList()
    private var list : MutableList<MaterialsList> = ArrayList()
    private lateinit var appDb : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appDb = AppDatabase.getDatabse(requireContext())
        list = get("Gate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_gate, container, false)
        // Inflate the layout for this fragment
        requireActivity().window.navigationBarColor = resources.getColor(R.color.purpD)
        appDb = AppDatabase.getDatabse(requireContext())
        var recyclerview : RecyclerView = inflate.findViewById(R.id.gatercv)
        recyclerview.layoutManager = LinearLayoutManager(context)
        var adapter = context?.let { CardAdapter(list,it)}
        recyclerview.adapter = adapter
        return inflate
    }

    fun get(type: String): MutableList<MaterialsList> {
        GlobalScope.launch {
            files.clear()
            files.addAll(appDb.appDao().getFile(type))
        }
        return files
    }
}