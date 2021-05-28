package com.tuwan.jetpackdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tuwan.jetpackdemo.databinding.FragmentTabOneBinding
import com.tuwan.jetpackdemo.databinding.FragmentTabThreeBinding

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
}