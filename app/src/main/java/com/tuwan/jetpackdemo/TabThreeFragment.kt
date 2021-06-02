package com.tuwan.jetpackdemo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tuwan.jetpackdemo.databinding.FragmentTabThreeBinding

import com.tuwan.jetpackdemo.ui.LiveDataActivity
import com.tuwan.jetpackdemo.ui.ViewModelDemo2Activity
import com.tuwan.jetpackdemo.ui.ViewModelDemoActivity

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 *
 * Created by austenYang on 2021/5/28-13:44
 * ================================================
 */
class TabThreeFragment : Fragment() {
    private lateinit var mBinding: FragmentTabThreeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentTabThreeBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.button.setOnClickListener {
            startActivity(Intent(activity, LiveDataActivity::class.java))
        }
        mBinding.buttonViewModel.setOnClickListener {
            startActivity(Intent(activity, ViewModelDemoActivity::class.java))
        }
        mBinding.buttonViewModelDataBinding.setOnClickListener {
            startActivity(Intent(activity, ViewModelDemo2Activity::class.java))
        }
    }
}