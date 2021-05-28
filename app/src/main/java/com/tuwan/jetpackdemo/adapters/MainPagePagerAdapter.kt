/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tuwan.jetpackdemo.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.tuwan.jetpackdemo.TabFourFragment


import com.tuwan.jetpackdemo.TabOneFragment
import com.tuwan.jetpackdemo.TabThreeFragment
import com.tuwan.jetpackdemo.TabTwoFragment

const val MAIN_TAB_ONE_PAGE_INDEX = 0
const val MAIN_TAB_TWO_PAGE_INDEX = 1
const val MAIN_TAB_THREE_PAGE_INDEX = 2
const val MAIN_TAB_FOUR_PAGE_INDEX = 3

class MainPagePagerAdapter(fragmentPagerAdapter: FragmentManager) :
    FragmentPagerAdapter(fragmentPagerAdapter, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    /**
     * Mapping of the ViewPager page indexes to their respective Fragments
     */
    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        MAIN_TAB_ONE_PAGE_INDEX to { TabOneFragment() }, // ()->Fragment 起到懒加载作用
        MAIN_TAB_TWO_PAGE_INDEX to { TabTwoFragment() },
        MAIN_TAB_THREE_PAGE_INDEX to { TabThreeFragment() },
        MAIN_TAB_FOUR_PAGE_INDEX to { TabFourFragment() }
    )

    override fun getCount() = tabFragmentsCreators.size

    override fun getItem(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }


}
