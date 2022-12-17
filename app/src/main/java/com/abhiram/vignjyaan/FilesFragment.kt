//package com.abhiram.vignjyaan
//
//import android.os.Bundle
//import android.util.Log
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.abhiram.vignjyaan.adapters.FilesAdapter
//import com.google.firebase.database.DataSnapshot
//import com.google.firebase.database.DatabaseError
//import com.google.firebase.database.ValueEventListener
//import com.google.firebase.database.ktx.database
//import com.google.firebase.ktx.Firebase
//
//class FilesFragment : Fragment() {
//    // TODO: Rename and change types of parameters
//    private var module: String? = null
//    private var type: String? = null
//    private var sem: String? = null
//    private var sub: String? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            module = it.getString("module")
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
//        val inflate = inflater.inflate(R.layout.fragment_files, container, false)
//        val path = "$type/$sem/$sub/$module"
//        val data = ArrayList<ItemsViewModel>()
//        Log.e("path","$path")
//        val database = Firebase.database
//        var myRef = database.getReference("$path")
//        val recyclerview = inflate.findViewById<RecyclerView>(R.id.recyclerview)
//        recyclerview.layoutManager = LinearLayoutManager(context)
//        val fileName = ArrayList<String>()
//        var size : Int = 0
//        myRef.addListenerForSingleValueEvent(
//            object: ValueEventListener{
////                override fun onDataChange(snapshot: DataSnapshot) {
////                    for (i in snapshot.children){
////                        fileName.add(i.key.toString())
////                        size+=1
////                        data.add(ItemsViewModel(i.key.toString()))
////                    }
//////                    val adapter = FilesAdapter(data, path!!)
////                    recyclerview.adapter = adapter
////
////                }
//                override fun onCancelled(error: DatabaseError) {
//                    TODO("Not yet implemented")
//                }
//            }
//        )
//        Log.e("size", "size = $fileName")
//        return inflate
//    }
//
//    companion object {
//        fun newInstance(param1: String, param2: String,param3: String, param4: String) =
//            FilesFragment().apply {
//                arguments = Bundle().apply {
//                    putString("module", param1)
//                    putString("sub", param2)
//                    putString("sem", param3)
//                    putString("type", param4)
//                }
//            }
//    }
//}