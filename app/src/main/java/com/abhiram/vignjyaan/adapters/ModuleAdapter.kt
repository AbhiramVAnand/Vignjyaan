package com.abhiram.vignjyaan.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.abhiram.vignjyaan.R
import com.abhiram.vignjyaan.fragments.NotesFragment

class ModuleAdapter(val context: Context, val type : String,val subcode : String, val fragTrans : FragmentTransaction) : RecyclerView.Adapter<ModuleAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card, parent, false)
        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val num = position+1
        holder.name.text = "Module $num"
        holder.name.setOnClickListener {
            Log.e("ModuleAdapter","hii")
            val fragment = NotesFragment.newInstance(type,subcode,num)
            fragTrans.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            ).replace(R.id.frag_view, fragment).addToBackStack("path").commit()
            Log.e("num",num.toString())
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return 5
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val name : TextView = ItemView.findViewById(R.id.crdname)
    }

}