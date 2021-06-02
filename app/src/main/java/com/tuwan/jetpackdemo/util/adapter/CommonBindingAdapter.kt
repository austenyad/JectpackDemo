package com.tuwan.jetpackdemo.util.adapter

import android.view.View
import androidx.databinding.BindingAdapter

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 *
 * Created by austenYang on 2021/6/1-13:14
 * ================================================
 */
object CommonBindingAdapter {

    @JvmStatic
    @BindingAdapter("visible", requireAll = false)
    fun visible(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

}