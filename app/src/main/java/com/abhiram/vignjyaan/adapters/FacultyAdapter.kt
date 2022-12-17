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

class FacultyAdapter(private val mList: List<Faculties>, val context: Context) : RecyclerView.Adapter<FacultyAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.staff, parent, false)
        Log.e("Made","Yes")
        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]
        holder.name.text = ItemsViewModel.name
        holder.mail.text = ItemsViewModel.mail
        holder.desg.text = ItemsViewModel.desgn
        holder.mail.setOnClickListener{
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:${mList[position].mail}")
            context.startActivity(intent)
        }
//        // sets the text to the textview from our itemHolder class
//        holder.textView.text = ItemsViewModel.text.toString()
//
//        holder.textView.setOnClickListener {
//            myRef.addListenerForSingleValueEvent(
//                object: ValueEventListener {
//                    override fun onDataChange(snapshot: DataSnapshot) {
//                        val value = snapshot.value
//                        val url = value.toString()
//                        Log.e("abhiram", "Value is: " + value)
//                        val pdfViewer : Intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                        holder.itemView.context.startActivity(pdfViewer)
//                    }
//
//                    override fun onCancelled(error: DatabaseError) {
//                        Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
//                    }
//                }
//            )
//
//        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val name : TextView = ItemView.findViewById(R.id.namcrd)
        val mail : TextView = ItemView.findViewById(R.id.crdmail)
        val desg : TextView = ItemView.findViewById(R.id.desgn)
    }

}