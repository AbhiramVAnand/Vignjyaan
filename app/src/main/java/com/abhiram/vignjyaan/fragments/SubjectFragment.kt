package com.abhiram.vignjyaan.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abhiram.vignjyaan.R
import com.abhiram.vignjyaan.adapters.CardAdapter
import com.abhiram.vignjyaan.adapters.SubAdapter
import com.abhiram.vignjyaan.database.AppDatabase
import com.abhiram.vignjyaan.database.MaterialsList
import com.abhiram.vignjyaan.database.Subjects
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class SubjectFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var type: String? = null
    private var sem: Int? = null
    private var sub : MutableList<Subjects> = ArrayList()
    private var sublist : MutableList<Subjects> = ArrayList()
    private lateinit var appDb : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            type = it.getString("type")
            sem = it.getInt("sem")
        }
        appDb = AppDatabase.getDatabse(requireContext())
        sublist = getSub(sem!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_subject, container, false)
        val fragTrans = parentFragmentManager.beginTransaction()
        var recyclerview : RecyclerView = inflate.findViewById(R.id.subrcv)
        recyclerview.layoutManager = LinearLayoutManager(context)
        var adapter = context?.let { SubAdapter(sublist,it, type.toString(),fragTrans) }
        recyclerview.adapter = adapter
        return inflate
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: Int) =
            SubjectFragment().apply {
                arguments = Bundle().apply {
                    putString("type", param1)
                    putInt("sem", param2)
                }
            }
    }

    fun getSub(sem : Int): MutableList<Subjects> {
        GlobalScope.launch {
            sub.clear()
            sub.addAll(appDb.appDao().getSub(sem))
        }
        return sub
    }
}