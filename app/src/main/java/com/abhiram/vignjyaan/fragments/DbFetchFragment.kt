package com.abhiram.vignjyaan.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abhiram.vignjyaan.R
import com.abhiram.vignjyaan.adapters.File
import com.abhiram.vignjyaan.database.AppDatabase
import com.abhiram.vignjyaan.database.MaterialsList
import com.abhiram.vignjyaan.database.Subjects
import com.abhiram.vignjyaan.startup.WelcomeFragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DbFetchFragment : Fragment() {
    lateinit var json : String
    private lateinit var appDb : AppDatabase
    var files : ArrayList<File> = ArrayList()
    var materials : ArrayList<MaterialsList> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        appDb = AppDatabase.getDatabse(requireContext())
        fetchData()
        fetchSub()
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    fun fetchData(){
        val database = Firebase.database
        val path = "Materials"
        var myRef = database.getReference("$path")
        val gson : Gson = Gson()

        myRef.addListenerForSingleValueEvent(
            object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (i in snapshot.children){
                        val file : Map<String,String> = i.value as Map<String, String>
                        Log.e("file",file.toString())
                        json = gson.toJson(file)
                        val temp : File = gson.fromJson(json,File::class.java)
                        files.add(temp)
                    }
                    test()
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            }
        )
    }

    fun fetchSub(){
        val database = Firebase.database
        val path = "Subjects"
        var myRef = database.getReference("$path")
        val gson : Gson = Gson()

        myRef.addListenerForSingleValueEvent(
            object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (i in snapshot.children){
                        val file : Map<String,String> = i.value as Map<String, String>
                        Log.e("file",file.toString())
                        json = gson.toJson(file)
                        val temp : Subjects = gson.fromJson(json,Subjects::class.java)
                        addSub(temp)
                    }
                    val fragmentManager = parentFragmentManager
                    val fragTrans = fragmentManager.beginTransaction()
                    fragTrans.setCustomAnimations(
                        R.anim.enter_from_right,
                        R.anim.exit_to_left,
                        R.anim.enter_from_left,
                        R.anim.exit_to_right
                    ).replace(R.id.frag_view, HomeFragment()).commit()
                }
                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            }
        )
    }

    fun test(){
        for (i in files){
            var sub: String = i.Subcode
            var type : String = i.Type
            val sem: Int = i.Sem
            var mod : Int = i.Module
            var link : String = i.Link
            val name: String = i.Name
            val material : MaterialsList = MaterialsList(sub,type,sem,mod,link,name)
            addFile(material)
        }
    }
    private fun addFile(file : MaterialsList){
        GlobalScope.launch(Dispatchers.IO) {
            appDb.appDao().add(file)
        }
    }

    private fun addSub(sub : Subjects){
        GlobalScope.launch(Dispatchers.IO) {
            appDb.appDao().addSub(sub)
        }
    }
}