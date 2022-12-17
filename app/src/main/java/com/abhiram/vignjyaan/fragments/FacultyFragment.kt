package com.abhiram.vignjyaan.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abhiram.vignjyaan.R
import com.abhiram.vignjyaan.adapters.FacultyAdapter
import com.abhiram.vignjyaan.database.AppDatabase
import com.abhiram.vignjyaan.database.Faculties
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.collections.ArrayList

class FacultyFragment : Fragment() {
    private lateinit var appDb : AppDatabase
    private var faculties : MutableList<Faculties> = ArrayList()
    private var techfac : MutableList<Faculties> = ArrayList()
    private var faculty : MutableList<Faculties> = ArrayList()
    private var tech : MutableList<Faculties> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appDb = AppDatabase.getDatabse(requireContext())
        faculty = getTeach("teach")
        tech = getTech("tech")
        Log.e("XList",faculty.toString())
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate =inflater.inflate(R.layout.fragment_faculty, container, false)
        requireActivity().window.navigationBarColor = resources.getColor(R.color.purpD)
        appDb = AppDatabase.getDatabse(requireContext())
        var recyclerview : RecyclerView = inflate.findViewById(R.id.recyclerview)
        var recyclerView2 : RecyclerView = inflate.findViewById(R.id.recyclerview2)
        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerView2.layoutManager = LinearLayoutManager(context)
        var adapter = context?.let { FacultyAdapter(faculty, it) }
        var adapter2 = context?.let { FacultyAdapter(tech, it) }
        recyclerview.adapter = adapter
        recyclerView2.adapter = adapter2
        return inflate
    }


    fun getTeach(type : String) : MutableList<Faculties>{
        GlobalScope.launch{
            faculties.clear()
            faculties.addAll(appDb.appDao().getFac(type))
        }
        return faculties
    }
    fun getTech(type : String) : MutableList<Faculties>{
        GlobalScope.launch{
            techfac.clear()
            techfac.addAll(appDb.appDao().getFac(type))
        }
        return techfac
    }
}