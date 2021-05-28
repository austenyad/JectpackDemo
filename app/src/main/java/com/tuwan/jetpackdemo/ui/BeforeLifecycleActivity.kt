package com.tuwan.jetpackdemo.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.tuwan.jetpackdemo.R

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 *
 * Created by austenYang on 2021/5/28-17:28
 * ================================================
 */
class BeforeLifecycleActivity : AppCompatActivity() {
    private lateinit var myLocationListener: MyLocationListener
    private lateinit var tvLocation: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_before_lifecycle)
        tvLocation = findViewById(R.id.tv_content)

        myLocationListener = MyLocationListener(this) { location ->

            // 更新UI
            tvLocation.text = location
        }
    }

    override fun onStart() {
        super.onStart()
        myLocationListener.start()
        // 管理其他需要响应activity生命周期的组件
    }

    override fun onStop() {
        super.onStop()
        myLocationListener.stop()
        // 管理其他需要响应activity生命周期的组件
    }
}