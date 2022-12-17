package com.abhiram.vignjyaan.startup

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abhiram.vignjyaan.fragments.HomeFragment
import com.abhiram.vignjyaan.R
import com.abhiram.vignjyaan.adapters.Faculty
import com.abhiram.vignjyaan.adapters.File
import com.abhiram.vignjyaan.database.AppDatabase
import com.abhiram.vignjyaan.database.Faculties
import com.abhiram.vignjyaan.database.MaterialsList
import com.abhiram.vignjyaan.database.Subjects
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*
import kotlin.concurrent.schedule


class SplashFragment : Fragment() {
    lateinit var json : String
    private lateinit var appDb : AppDatabase
    var files : ArrayList<File> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_splash, container, false)
        requireActivity().window.navigationBarColor = resources.getColor(R.color.purpD)
        var fragmentManager = parentFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()
        val flagSp = context?.getSharedPreferences("com.abhiram.vignjyaan", Context.MODE_PRIVATE)
        val flag = flagSp!!.getInt("isfirst",0)
        var fetch = flagSp!!.getInt("fetch", 0)
        if(fetch==0){
            appDb = AppDatabase.getDatabse(requireContext())
            fetchData()
            fetchSub()
            fetchFaculty()
            flagSp!!.edit().putInt("fetch", fetch+1).apply()
        }else if(fetch==8){
            flagSp!!.edit().putInt("fetch", 0).apply()
        }else{
            flagSp!!.edit().putInt("fetch", fetch+1).apply()
        }
        Log.e("fetch", fetch.toString())
        Timer().schedule(3000) {
            if (flag==1) {
                fragmentTransaction.setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.exit_to_left,
                    R.anim.enter_from_left,
                    R.anim.exit_to_right
                ).replace(R.id.frag_view, HomeFragment()).commit()
            } else {
                fragmentTransaction.setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.exit_to_left,
                    R.anim.enter_from_left,
                    R.anim.exit_to_right
                ).replace(R.id.frag_view, WelcomeFragment()).commit()
            }
        }
        return inflate
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
                        val temp : File = gson.fromJson(json, File::class.java)
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
    fun fetchFaculty(){
        val database = Firebase.database
        val path = "Faculty"
        var myRef = database.getReference("$path")
        val gson : Gson = Gson()

        myRef.addListenerForSingleValueEvent(
            object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var j : Int = 0
                    for (i in snapshot.children){
                        val faculty : Map<String,String> = i.value as Map<String, String>
                        Log.e("file",i.toString())
                        json = gson.toJson(faculty)
                        val temp : Faculty = gson.fromJson(json, Faculty::class.java)
                        val fac : Faculties = Faculties(temp.name,temp.type,temp.mail,temp.designation,j)
                        j = j+1
                        addFaculty(fac)
                    }
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
                        val temp : Subjects = gson.fromJson(json, Subjects::class.java)
                        addSub(temp)
                    }
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
    private fun addFaculty(faculty : Faculties){
        GlobalScope.launch(Dispatchers.IO) {
            appDb.appDao().addFaculty(faculty)
        }
    }
    private fun addSub(sub : Subjects){
        GlobalScope.launch(Dispatchers.IO) {
            appDb.appDao().addSub(sub)
        }
    }
}