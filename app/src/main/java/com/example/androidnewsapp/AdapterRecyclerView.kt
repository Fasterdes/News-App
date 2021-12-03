package com.example.androidnewsapp

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdapterRecyclerView(
    var context: Context,
    var dataGambar: ArrayList<Drawable?>,
    var dataJudul: ArrayList<String>,
    var dataDeskripsi: ArrayList<String>
) :
    RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var deskripsi: TextView
        var judul: TextView
        var image: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            judul = view.findViewById(R.id.judul)
            image = view.findViewById(R.id.img)
            deskripsi = view.findViewById(R.id.deskripsi)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.model_rv, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Glide
            .with(context)
            .load(dataGambar[position])
            .centerCrop()
            .into(viewHolder.image);
        viewHolder.judul.text = dataJudul[position]
        viewHolder.deskripsi.text = dataDeskripsi[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataDeskripsi.size

}