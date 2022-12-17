package com.abhiram.vignjyaan.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.abhiram.vignjyaan.R
import com.abhiram.vignjyaan.database.Faculties
import com.abhiram.vignjyaan.database.MaterialsList
import com.abhiram.vignjyaan.database.Subjects
import com.abhiram.vignjyaan.fragments.FileFragment

class SubAdapter(private val mList: List<Subjects>, val context: Context,val type : String,val fragTrans : FragmentTransaction) : RecyclerView.Adapter<SubAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card, parent, false)
        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]
        holder.name.text = ItemsViewModel.subName
        holder.name.setOnClickListener {
            val fragment = FileFragment.newInstance(type,ItemsViewModel.subCode)
            fragTrans.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            ).replace(R.id.frag_view, fragment).addToBackStack("path").commit()
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val name : TextView = ItemView.findViewById(R.id.crdname)
    }

}