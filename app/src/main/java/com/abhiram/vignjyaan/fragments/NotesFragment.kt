package com.abhiram.vignjyaan.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abhiram.vignjyaan.R
import com.abhiram.vignjyaan.adapters.CardAdapter
import com.abhiram.vignjyaan.database.AppDatabase
import com.abhiram.vignjyaan.database.MaterialsList
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NotesFragment : Fragment() {
    private var type: String? = null
    private var subcode: String? = null
    private var module : Int? = 0
    private var files : MutableList<MaterialsList> = ArrayList()
    private var list : MutableList<MaterialsList> = ArrayList()
    private lateinit var appDb : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            type = it.getString("type")
            subcode = it.getString("subcode")
            module = it.getInt("module")
        }
        appDb = AppDatabase.getDatabse(requireContext())
        list = get(type.toString(), subcode.toString(), module)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_notes, container, false)
        Log.e("created","yes")
        for(i in list){
            Log.e("note",i.mod.toString())
        }
        requireActivity().window.navigationBarColor = resources.getColor(R.color.purpD)
        appDb = AppDatabase.getDatabse(requireContext())
        var recyclerview : RecyclerView = inflate.findViewById(R.id.noteRV)
        recyclerview.layoutManager = LinearLayoutManager(context)
        var adapter = context?.let { CardAdapter(list,it,type.toString()) }
        recyclerview.adapter = adapter
        return inflate
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String, param3: Int) =
            NotesFragment().apply {
                arguments = Bundle().apply {
                    putString("type", param1)
                    putString("subcode", param2)
                    putInt("module", param3)
                }
            }
    }
    fun get(type: String, sub:String, module: Int?): MutableList<MaterialsList> {
        GlobalScope.launch {
            files.clear()
            files.addAll(appDb.appDao().getNotes(type,sub,module))
        }
        return files
    }
}