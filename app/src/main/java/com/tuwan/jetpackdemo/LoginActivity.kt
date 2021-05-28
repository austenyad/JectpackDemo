package com.tuwan.jetpackdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.tuwan.jetpackdemo.databinding.ActivityLoginBinding
import com.tuwan.jetpackdemo.viewmodels.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private val loginViewModel: LoginViewModel by viewModels()
    private lateinit var mBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        mBinding.vm = loginViewModel
        mBinding.lifecycleOwner = this
        setContentView(mBinding.root)

        loginViewModel.getLoginStatus().observe(this) {
            if (it) startActivity(Intent(this, MainActivity::class.java))
        }

    }
}