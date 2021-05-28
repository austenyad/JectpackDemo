package com.tuwan.jetpackdemo.viewmodels

import androidx.lifecycle.ViewModel
import com.tuwan.jetpackdemo.entity.Item

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 *
 * Created by austenYang on 2021/5/28-14:44
 * ================================================
 */
class TabOneViewModel : ViewModel() {
    private var nextPage = 1

    fun getNextPage(success: (data: MutableList<Item>) -> Unit) {
        val data = mutableListOf<Item>()
        for (i in 0..19) {
            data.add(Item("第 $nextPage 页", "这是本页第 $i 首歌", false))
        }
        ++nextPage
        success(data)
    }

}