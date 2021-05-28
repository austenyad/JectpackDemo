package com.tuwan.jetpackdemo.entity

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 *
 *
 *
 * Created by austenYang on 2021/5/28-14:37
 * ================================================
 */
class Item(
    @get:Bindable var title: String, @get:Bindable var subTitle: String,
    @get:Bindable var isPlaying: Boolean
) : BaseObservable()