package com.kotlinproject.spotifyclone.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.kotlinproject.spotifyclone.fragments.HomeFragment
import com.kotlinproject.spotifyclone.fragments.LibraryFragment
import com.kotlinproject.spotifyclone.fragments.PremiumFragment
import com.kotlinproject.spotifyclone.fragments.SearchFragment

class MyPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                HomeFragment()
            }
            1 ->{
                SearchFragment()
            }

            2 -> {
                LibraryFragment()
            }

            3 -> {
                PremiumFragment()
            }
            else -> {
                return Fragment()
            }
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when(position){
            0 -> "ANASAYFA"
            1 -> "ARA"
            2 -> "KİTAPLIĞIN"
            3 -> "PREMİUM"
            else -> {
                return "" }
        }

    }
}