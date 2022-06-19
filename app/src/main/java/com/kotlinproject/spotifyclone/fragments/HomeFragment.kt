package com.kotlinproject.spotifyclone.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kotlinproject.spotifyclone.Data.AdviceForYouDTO
import com.kotlinproject.spotifyclone.Data.OnBoard
import com.kotlinproject.spotifyclone.Data.RecentPlayedDTO
import com.kotlinproject.spotifyclone.R
import com.kotlinproject.spotifyclone.adapters.AdviceForYouAdapter
import com.kotlinproject.spotifyclone.adapters.OnBoardAdapters
import com.kotlinproject.spotifyclone.adapters.RecentRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {


    @SuppressLint("WrongConstant")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment


        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        val recycler = view.findViewById<RecyclerView>(R.id.recently_played_recycler)

        recycler.layoutManager = LinearLayoutManager(view.context, LinearLayout.HORIZONTAL,false)


        val adviceRecycler = view.findViewById<RecyclerView>(R.id.advice_for_you_recycler)
        adviceRecycler.layoutManager = LinearLayoutManager(view.context, LinearLayout.HORIZONTAL, false)

        val  OnBoardAdapters: OnBoardAdapters
       var dataList = mutableListOf<OnBoard>()

        val albums = ArrayList<RecentPlayedDTO>()
        albums.add(RecentPlayedDTO("https://m.media-amazon.com/images/I/51hJnI9-rZL._AA256_.jpg", "Under the Covers"))
        albums.add(RecentPlayedDTO("https://lineup-images.scdn.co/time-capsule_DEFAULT-en.jpg", "Zaman Kapsülün"))
        albums.add(RecentPlayedDTO("https://spotify.i.lithium.com/t5/image/serverpage/image-id/60013i7710A8EFA4ECD096/image-size/large?v=1.0&px=999", "Haftalık Keşif"))

        val adapter = RecentRecyclerAdapter(albums)
        recycler.adapter = adapter


        //Glide.with(this).load("https://pbs.twimg.com/media/CtcVNESWIAEYGWI.jpg").into(imgForYou)

        val adviceAlbums = ArrayList<AdviceForYouDTO>()
        adviceAlbums.add(AdviceForYouDTO("https://i.scdn.co/image/ab67616d0000b273d883931be2f5cdf9c9270088", "Feelin Good"))
        adviceAlbums.add(AdviceForYouDTO("https://i.scdn.co/image/7f587bc2606cdd9907d7452e92a2158c63fa8a6e", "Yeni Müzik Radarı"))
         //adviceAlbums.add(AdviceForYouDTO("https://m.media-amazon.com/images/I/51hJnI9-rZL._AA256_.jpg", "Under the Covers by Alice Fredenham"))
        adviceAlbums.add(AdviceForYouDTO("https://lineup-images.scdn.co/wrapped-2021-top100_LARGE-tr.jpg", "2021 Şarkıların"))


         val adviceAdapter = AdviceForYouAdapter(adviceAlbums)
        adviceRecycler.adapter=adviceAdapter


        val onBoardCardView = view.findViewById<RecyclerView>(R.id.onBoardCardView)

        onBoardCardView.layoutManager = GridLayoutManager(view.context,2)
        OnBoardAdapters = OnBoardAdapters(view.context)
        onBoardCardView.adapter = OnBoardAdapters

        //add data
        dataList.add(OnBoard("Summer Party Time","https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/2aa71041442859.57a62518bfab2.jpg"))
        dataList.add(OnBoard("Burn by Tiesto","https://dancingastronaut.com/wp-content/uploads/2015/06/spotify-burn-by-tiesto.jpg",))
        dataList.add(OnBoard("Tekrar Tekrar","https://daily-mix.scdn.co/covers/on_repeat/PZN_On_Repeat2_LARGE-en.jpg",))
        dataList.add(OnBoard("Türkiye En İyi 50 ","https://charts-images.scdn.co/assets/locale_en/viral/daily/region_tr_large.jpg",))


        OnBoardAdapters.setDataList(dataList)

        return view
    }



}