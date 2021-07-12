package com.example.viewpager.utils

import android.media.MediaExtractor
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpager.fragments.cats.CatsFragment
import com.example.viewpager.fragments.dogs.DogsFragment
import com.example.viewpager.fragments.empty.EmptyFragment

private const val FRAGMENT_COUNT=2
class ViewPagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = FRAGMENT_COUNT

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->DogsFragment()
            1->CatsFragment()

            else->EmptyFragment()
        }

    }

}