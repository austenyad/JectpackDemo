package com.tuwan.jetpackdemo.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.tuwan.jetpackdemo.R
import com.tuwan.jetpackdemo.viewmodels.MyViewModel


/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 * 1. Activity 因为配置改变导致 Activity 重新创建 ，-- 以前界面的数据怎么恢复
 * 2. 潜在的内存泄漏：异步请求需要一些时间才能返回，如果逻辑层持有UI层（如 Context）,那么 UI 层需要管理这些请求，
 * 确保界面销毁后清除这些调用以 避免潜在的内存泄漏。
 *
 * Created by austenYang on 2021/5/31-09:53
 * ================================================
 */
const val TAGA = "ViewModelDemoActivity"
class ViewModelDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmode_demo)
        val tvContent = findViewById<TextView>(R.id.tv_content)
        val btnLoadingData = findViewById<Button>(R.id.btn_loading_data)
        val progressLoading = findViewById<ProgressBar>(R.id.progress_loading)

        Log.e(TAGA, "onCreate: ")

        val viewModelProvider = ViewModelProvider(this)

        //获取 ViewModel 实例
        val myViewModel = viewModelProvider.get(MyViewModel::class.java)


        // 观察 ViewModel
        myViewModel.getUserLiveData().observe(this) {
            if (it!!.isNotEmpty()) {
                tvContent.visibility = View.VISIBLE
                tvContent.text = it
            } else {
                tvContent.visibility = View.GONE
            }




        }
        myViewModel.getLoadingData().observe(this) {
            progressLoading.visibility = if (it) View.VISIBLE else View.GONE
        }

        btnLoadingData.setOnClickListener {
            myViewModel.getUserInfo()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.e(TAGA, "onStart: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAGA, "onDestroy: ")
    }
}