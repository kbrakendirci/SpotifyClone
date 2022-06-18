package com.kotlinproject.spotifyclone.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kotlinproject.spotifyclone.Data.AdviceForYouDTO
import com.kotlinproject.spotifyclone.Data.RecentPlayedDTO
import com.kotlinproject.spotifyclone.R
import com.kotlinproject.spotifyclone.adapters.AdviceForYouAdapter
import com.kotlinproject.spotifyclone.adapters.RecentRecyclerAdapter


class HomeFragment : Fragment() {


    @SuppressLint("WrongConstant")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment


        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        val recycler = view.findViewById<RecyclerView>(R.id.recently_played_recycler)
        val imgForYou = view.findViewById<ImageView>(R.id.imgForYou)
        recycler.layoutManager = LinearLayoutManager(view.context, LinearLayout.HORIZONTAL,false)

        val dailyRecycler = view.findViewById<RecyclerView>(R.id.daily_mixes_recycler)
        dailyRecycler.layoutManager = LinearLayoutManager(view.context, LinearLayout.HORIZONTAL, false)

        val adviceRecycler = view.findViewById<RecyclerView>(R.id.advice_for_you_recycler)
        adviceRecycler.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)


        val albums = ArrayList<RecentPlayedDTO>()
        albums.add(RecentPlayedDTO("https://i.pinimg.com/236x/9d/e7/7a/9de77a1ffc2cd752887d04f1dffb1650.jpg", "Feenixpawl - Love me for life"))
        albums.add(RecentPlayedDTO("https://lineup-images.scdn.co/time-capsule_DEFAULT-en.jpg", "Zaman Kapsülün"))
        albums.add(RecentPlayedDTO("https://spotify.i.lithium.com/t5/image/serverpage/image-id/60013i7710A8EFA4ECD096/image-size/large?v=1.0&px=999", "Haftalık Keşif"))
        albums.add(RecentPlayedDTO("https://i.scdn.co/image/913c7ccb86562d204b191ae6eed52c2853b90094", "In My Mind"))
        albums.add(RecentPlayedDTO("https://i.scdn.co/image/7f587bc2606cdd9907d7452e92a2158c63fa8a6e", "Yeni Müzik Radarı"))
        albums.add(RecentPlayedDTO("http://cms.djs.com/media/dj-images/tmpLUtNdM", "Future Music"))
        albums.add(RecentPlayedDTO("https://i.scdn.co/image/fece8f48a6aee190dd775ceb8573e549275a44f0", "Skrillex - Would You Ever"))


        Glide.with(this).load("https://pbs.twimg.com/media/CtcVNESWIAEYGWI.jpg").into(imgForYou)

        val adviceAlbums = ArrayList<AdviceForYouDTO>()
        adviceAlbums.add(AdviceForYouDTO("https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/2aa71041442859.57a62518bfab2.jpg", "Summer Party Time"))
        adviceAlbums.add(AdviceForYouDTO("https://dancingastronaut.com/wp-content/uploads/2015/06/spotify-burn-by-tiesto.jpg", "Burn by Tiesto"))
        adviceAlbums.add(AdviceForYouDTO("https://crank11.news/wp-content/uploads/sites/3/2017/10/f7936138d7ec4d805be588d495406f30.jpg", "Lany's New Single"))
        adviceAlbums.add(AdviceForYouDTO("https://m.media-amazon.com/images/I/51hJnI9-rZL._AA256_.jpg", "Under the Covers by Alice Fredenham"))
        adviceAlbums.add(AdviceForYouDTO("https://vignette.wikia.nocookie.net/rockband/images/3/30/Superunknown.png/revision/latest?cb=20120908003216", "Black Hole Sun"))
        adviceAlbums.add(AdviceForYouDTO("https://i.scdn.co/image/5dc1d866121c0e8d7063996841c1023ea95ea0e6", "Toulouse - Original Mix, a song by Nicky Romero"))
        val adapter = RecentRecyclerAdapter(albums)
        recycler.adapter=adapter

        val dailyAdapter = RecentRecyclerAdapter(albums)
        dailyRecycler.adapter = dailyAdapter

        val adviceAdapter = AdviceForYouAdapter(adviceAlbums)
        adviceRecycler.adapter = adviceAdapter

        adviceRecycler.isNestedScrollingEnabled = false

        return view
    }



}