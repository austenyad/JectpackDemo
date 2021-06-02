package com.tuwan.jetpackdemo.viewmodels

import android.os.AsyncTask
import android.view.View
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 * 1. extends ViewModel
 * 2. 在 ViewModel  中编写逻辑 获取数据 UI数据
 * 3. 使用 LiveData 将获取的 UI 数据抛出
 * 4. 在 Activity / Fragment 中 使用 ViewModelProvider 获取 MyViewModel 实例
 * 5. 观察 MyViewModel 中的 LiveData 数据，进行 UI 更新
 *
 * Created by austenYang on 2021/5/31-11:39
 * ================================================
 */

class MyViewModel2 : ViewModel(), LifecycleObserver {
    val userLiveData: MutableLiveData<String?> = MutableLiveData()
    val loadingLiveData: MutableLiveData<Boolean> = MutableLiveData()


    fun getUserInfo() {
        loadingLiveData.value = true
        userLiveData.value = ""
        object : AsyncTask<Void, Void, String>() {
            override fun onPostExecute(result: String?) {
                loadingLiveData.value = false
                userLiveData.value = result //抛出用户信息
            }

            override fun doInBackground(vararg params: Void?): String {
                try {
                    Thread.sleep(2000)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                return "获取到网络数据了"

            }
        }.execute()

    }
}