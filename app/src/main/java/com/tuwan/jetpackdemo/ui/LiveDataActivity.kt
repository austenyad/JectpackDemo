package com.tuwan.jetpackdemo.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.tuwan.jetpackdemo.R

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 *
 * Created by austenYang on 2021/5/29-17:05
 * ================================================
 */
const val TAG = "LiveDataActivity"

class LiveDataActivity : AppCompatActivity() {
    private val mLiveData: MutableLiveData<String> = MutableLiveData<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livedata)



        mLiveData.observe(this) {
            Log.e(TAG, "onChanged: $it")
        }

        Log.e(TAG, "onCreate")

        mLiveData.value = "onCreate"
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart: ")
        mLiveData.value = "onStart"
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume: ")
        mLiveData.value = "onResume"
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause: ")
        mLiveData.value = "onPause"
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop: ")
        mLiveData.value = "onStop"
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: ")
        mLiveData.value = "onDestroy"
    }


}