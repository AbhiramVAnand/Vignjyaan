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
import androidx.recyclerview.widget.RecyclerView
import com.abhiram.vignjyaan.R
import com.abhiram.vignjyaan.database.Faculties
import com.abhiram.vignjyaan.database.MaterialsList

class CardAdapter(private val mList: List<MaterialsList>, val context: Context) : RecyclerView.Adapter<CardAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card, parent, false)
        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]
        holder.name.text = ItemsViewModel.name
        holder.name.setOnClickListener {
            val link: String = ItemsViewModel.link
            val pdfViewer : Intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            context.startActivity(pdfViewer)
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