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
 *f
 * Created by austenYang on 2021/5/28-18:34
 * ================================================
 */
class LifecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)


        val tvContent = findViewById<TextView>(R.id.tvContent)




        lifecycle.addObserver(MyLifecycleLocationListener{
            tvContent.text = it
        })


    }
}