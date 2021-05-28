package com.tuwan.jetpackdemo.ui

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import kotlin.concurrent.thread


/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 *
 * Created by austenYang on 2021/5/28-17:36
 * ================================================
 */
class MyLocationListener(context: Context, private val locationUpdateCallback: (String) -> Unit) {
    companion object {
        private val TAG = "MyLocationListener"
    }

    private val H: Handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.what == 1) {
                update()
                sendEmptyMessageDelayed(1, 1000)
                Log.e(TAG, "update: ")
            }

        }
    }

    fun start() {
        // 链接系统定位服务
        // 1. 假设链接定位服务需要的时间不清楚 可能长可能短

        H.sendEmptyMessageDelayed(1, 1000)


    }

    private var location: Int = 0

    private fun update() {
        locationUpdateCallback.invoke("位置 ${location++}")

    }


    fun stop() {
        // 断开系统定位服务
        H.removeMessages(1)
        H.removeCallbacksAndMessages(null)

    }


}

