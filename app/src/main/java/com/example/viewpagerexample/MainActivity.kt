package com.example.viewpagerexample

import android.media.Image
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagerexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var titleList = mutableListOf<String>()
    private var detailList = mutableListOf<String>()
    private var imageList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        postToList()

        binding.viewpager.adapter = ViewPagerAdapter(titleList,detailList,imageList)
        binding.viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.indicator.setViewPager(binding.viewpager)
    }

    private fun addToList(title: String, details: String, image: Int){
        titleList.add(title)
        detailList.add(details)
        imageList.add(image)
    }

    private fun postToList() {
        for (i: Int in 1..5) {
            addToList("Title$i", "Description$i", R.mipmap.ic_launcher_round)
        }
    }
}