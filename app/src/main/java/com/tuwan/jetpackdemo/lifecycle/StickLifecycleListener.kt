package com.tuwan.jetpackdemo.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 *
 *
 *
 * Created by austenYang on 2021/5/29-16:53
 * ================================================
 */
const val TAG = "StickLifecycleListener"

class StickLifecycleListener : LifecycleObserver {

    @OnLifecycleEvent(value = Lifecycle.Event.ON_ANY)
    private fun onEvent(owner: LifecycleOwner, event: Lifecycle.Event) {
        Log.e(TAG, "onEvent: ${event.name}")
    }
}