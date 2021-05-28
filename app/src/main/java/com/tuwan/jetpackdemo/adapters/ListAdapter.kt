package com.tuwan.jetpackdemo.adapters

import android.widget.Toast
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.BaseLoadMoreModule
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.tuwan.jetpackdemo.R
import com.tuwan.jetpackdemo.databinding.ItemOneLayoutBinding
import com.tuwan.jetpackdemo.entity.Item

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 *
 * Created by austenYang on 2021/5/28-14:36
 * ================================================
 */
class ListAdapter :
    BaseQuickAdapter<Item, BaseDataBindingHolder<ItemOneLayoutBinding>>(
        R.layout.item_one_layout,
        mutableListOf()
    ), LoadMoreModule {
    override fun convert(holder: BaseDataBindingHolder<ItemOneLayoutBinding>, item: Item) {
        holder.setText(R.id.tv_title, item.title)
            .setText(R.id.tv_artist, item.subTitle)
            .setVisible(R.id.iv_play_status, item.isPlaying)
    }

    /**
     * 当前播放曲目index，没有返回-1
     */
    fun currentPlayingIndex() = data.indexOfFirst { it.isPlaying }

    fun changeToIndex(index: Int) {
        val currentIndex = currentPlayingIndex()
        if (index == currentIndex) return

        if (currentIndex != -1) {
            data[currentIndex].isPlaying = false
            notifyItemChanged(currentIndex)
        }
        data[index].isPlaying = true
        notifyItemChanged(index)
        notifyDataSetChanged()
    }

    fun changeToNext() {
        val currentIndex = currentPlayingIndex()
        if (currentIndex == data.size - 1) {
            Toast.makeText(context, "已经是最后一首了", Toast.LENGTH_SHORT).show()
            return
        }

        changeToIndex(currentPlayingIndex() + 1)
    }

    fun changeToPrev() {
        val currentIndex = currentPlayingIndex()
        if (currentIndex == 0) {
            Toast.makeText(context, "已经是第一首了", Toast.LENGTH_SHORT).show()
            return
        }

        changeToIndex(currentPlayingIndex() - 1)
    }
}