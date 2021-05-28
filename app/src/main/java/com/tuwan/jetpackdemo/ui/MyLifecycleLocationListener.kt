 package com.tuwan.jetpackdemo.ui

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import kotlin.concurrent.thread

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 *
 * Created by austenYang on 2021/5/28-18:36
 * ================================================
 */
class MyLifecycleLocationListener(private val locationUpdateCallback: (String) -> Unit) :
    LifecycleObserver {

    companion object {
        private val TAG = "MyLifecycleLocationListener"
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

    @OnLifecycleEvent(value = Lifecycle.Event.ON_RESUME)
    private fun start(owner: LifecycleOwner) {
        // 链接系统定位服务
        // 1. 假设链接定位服务需要的时间不清楚 可能长可能短
        thread {
            Thread.sleep(5000)

            H.sendEmptyMessageDelayed(1, 1000)

            owner.lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)
        }

    }


    private var location: Int = 0

    private fun update() {
        locationUpdateCallback.invoke("位置 ${location++}")

    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_STOP)
    private fun stop() {
        // 断开系统定位服务
        H.removeMessages(1)
        H.removeCallbacksAndMessages(null)

    }
}