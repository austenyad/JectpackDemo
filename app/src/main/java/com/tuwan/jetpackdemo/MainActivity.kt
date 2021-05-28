package com.tuwan.jetpackdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tuwan.jetpackdemo.adapters.MainPagePagerAdapter
import com.tuwan.jetpackdemo.databinding.ActivityMainBinding

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 *
 * Created by austenYang on 2021/5/28-11:21
 * ================================================
 */
class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)

        val viewPager = mBinding.viewPager
        viewPager.adapter = MainPagePagerAdapter(supportFragmentManager)

        setContentView(mBinding.root)

    }
}