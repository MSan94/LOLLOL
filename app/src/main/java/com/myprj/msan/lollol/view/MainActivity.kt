package com.myprj.msan.lollol.view

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.myprj.msan.lollol.R
import com.myprj.msan.lollol.fragment.community.CommunityFragment
import com.myprj.msan.lollol.fragment.content.*
import com.myprj.msan.lollol.fragment.favorites.FavoritesFragment
import com.myprj.msan.lollol.fragment.home.HomeFragment
import com.myprj.msan.lollol.fragment.mypage.MyPageFragment

class MainActivity : AppCompatActivity(), HomeFragment.onDataPassListener {
    private val bottomNavigationView: BottomNavigationView by lazy { findViewById(R.id.bottomNavigationView) }

    // 네비게이션 메뉴
    private val homeFragment = HomeFragment()
    private val communityFragment = CommunityFragment()
    private val favoritesFragment = FavoritesFragment()
    private val myPageFragment = MyPageFragment()

    //컨텐트 프래그먼트
    private val introFragment = IntroFragment()
    private val itemFragment = ItemFragment()
    private val lotationFragment = LotationFragment()
    private val matchFragment = MatchFragment()
    private val mapFragment = MapFragment()
    private val tipFragment = TipFragment()

    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(homeFragment)

        /**
         * NavigationView 프래그먼트 Replace
         */
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(homeFragment)
                R.id.community -> replaceFragment(communityFragment)
                R.id.favorites -> replaceFragment(favoritesFragment)
                R.id.mypage -> replaceFragment(myPageFragment)
            }
            true
        }

    }


    override fun onStart() {
        super.onStart()
//        if(auth.currentUser == null){
//            startActivity(Intent(this,LoginActivity::class.java))
//        }
    }


    /**
     * NavigationView 프래그먼트 Replace
     * @author ms
     */
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    /**
     * 프래그먼트 버튼 아이디 get
     */
    override fun onDataSend(buttonId: Int?) {
        when (buttonId) {
            1 -> replaceFragment(introFragment)
            2 -> replaceFragment(itemFragment)
            3 -> replaceFragment(lotationFragment)
            4 -> replaceFragment(matchFragment)
            5 -> replaceFragment(mapFragment)
            6 -> replaceFragment(tipFragment)
        }
    }


}