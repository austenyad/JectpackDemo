package com.tuwan.jetpackdemo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.tuwan.jetpackdemo.databinding.FragmentTabTwoBinding
import com.tuwan.jetpackdemo.lifecycle.StickLifecycleListener
import com.tuwan.jetpackdemo.ui.BeforeLifecycleActivity
import com.tuwan.jetpackdemo.ui.LifecycleActivity

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 *
 * Created by austenYang on 2021/5/28-13:44
 * ================================================
 */
class TabTwoFragment : Fragment() {
    private lateinit var mBinding: FragmentTabTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentTabTwoBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.btnBeforeLifecycle.setOnClickListener {
            startActivity(Intent(activity, BeforeLifecycleActivity::class.java))
        }
        mBinding.btnLifecycle.setOnClickListener {
            startActivity(Intent(activity, LifecycleActivity::class.java))
        }
        mBinding.btnLifecycleStick.setOnClickListener {
            lifecycle.addObserver(StickLifecycleListener())
//            startActivity(Intent(activity, LifecycleActivity::class.java))
        }
    }
}