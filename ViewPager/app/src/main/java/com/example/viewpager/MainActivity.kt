package com.example.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager.utils.ViewPagerAdapter
import com.example.viewpager.utils.ZoomOutPageTransformer

class MainActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews(){
        viewPager=findViewById(R.id.viewPager)
    }

    private fun initViewPager(){
        val adapter=ViewPagerAdapter(this)

        viewPager.setPageTransformer(ZoomOutPageTransformer())
        viewPager.adapter=adapter
    }
}