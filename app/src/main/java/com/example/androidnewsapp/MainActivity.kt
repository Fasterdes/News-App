package com.example.androidnewsapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageList = ArrayList<SlideModel>() // Create image list

        // imageList.add(SlideModel("String Url" or R.drawable)
        // imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title

        imageList.add(SlideModel(R.drawable.img1, "This is slider 1"))
        imageList.add(SlideModel(R.drawable.img3, "This is slide 2"))
        imageList.add(SlideModel(R.drawable.img2, "This is slider 3"))

        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        imageSlider.startSliding(3000) // with new period
        imageSlider.startSliding()
        imageSlider.stopSliding()

        val dataGambar = arrayListOf(getDrawable((R.drawable.img1)), getDrawable(R.drawable.img3), getDrawable(R.drawable.img2))

        val dataJudul = arrayListOf(
            "Tropical 1",
            "Tropical 2",
            "Tropical 3")

        val dataDeskripsi = arrayListOf(
            "Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical",
            "Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical",
            "Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical Tropical"
        )
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AdapterRecyclerView(this,dataGambar, dataJudul, dataDeskripsi)
        recyclerView.setHasFixedSize(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}