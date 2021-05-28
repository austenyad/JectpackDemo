package com.tuwan.jetpackdemo.viewmodels

import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import kotlin.concurrent.thread

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 *
 * Created by austenYang on 2021/5/28-09:48
 * ================================================
 */
class LoginViewModel : ViewModel() {


    //    val phoneNumber: ObservableField<String> = ObservableField()
//    val password: ObservableField<String> = ObservableField()
    val phoneNumber: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()

     val tvContent: MutableLiveData<String> = MutableLiveData()

    private val loginStatus: MutableLiveData<Boolean> = MutableLiveData()

    fun getLoginStatus(): LiveData<Boolean> = loginStatus

//    fun getTvContent(): LiveData<String> = tvContent

//    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
//    fun onResume() {
//        Log.e("LoginViewModel", "onResume")
//
//
//    }

    fun login(v: View) {
//        Log.e("LoginViewModel", "${password.get()}")
//        Log.e("LoginViewModel", "${phoneNumber.get()}")
        Log.e("LoginViewModel", "${password.value}")
        Log.e("LoginViewModel", "${phoneNumber.value}")
        thread {
//            Thread.sleep(2000)
            tvContent.postValue("2000")
            loginStatus.postValue(true)

        }

    }


}