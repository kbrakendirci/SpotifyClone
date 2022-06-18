package com.kotlinproject.spotifyclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.kotlinproject.spotifyclone.adapters.MyPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val viewPager : ViewPager = findViewById(R.id.viewpager_main)
        val tabLayout : TabLayout = findViewById(R.id.tabs_main)

        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        viewPager.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewPager)

        setupIcons()
    }

    private fun setupIcons() {
        tabs_main.getTabAt(0)!!.setIcon(R.drawable.home_btn)
        tabs_main.getTabAt(1)!!.setIcon(R.drawable.search)
        tabs_main.getTabAt(2)!!.setIcon(R.drawable.music_library_icon)
        tabs_main.getTabAt(3)!!.setIcon(R.drawable.browse_icon)

    }
}