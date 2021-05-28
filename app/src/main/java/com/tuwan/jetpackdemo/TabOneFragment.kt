package com.tuwan.jetpackdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tuwan.jetpackdemo.adapters.ListAdapter
import com.tuwan.jetpackdemo.databinding.FragmentTabOneBinding
import com.tuwan.jetpackdemo.viewmodels.TabOneViewModel

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 *
 * Created by austenYang on 2021/5/28-13:44
 * ================================================
 */
class TabOneFragment : Fragment() {
    private lateinit var mBinding: FragmentTabOneBinding
    private val tabOneViewModel: TabOneViewModel by viewModels()
    private val listAdapter = ListAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentTabOneBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initList()
        mBinding.btnPre.setOnClickListener {
            listAdapter.changeToPrev()
        }

        mBinding.btnNext.setOnClickListener {
            listAdapter.changeToNext()
        }
    }

    private fun initList() {

        val loadMoreModule = listAdapter.loadMoreModule

        loadMoreModule.setOnLoadMoreListener {
            tabOneViewModel.getNextPage {
                listAdapter.addData(it)
                loadMoreModule.loadMoreComplete()
            }
        }

        listAdapter.setOnItemClickListener { _, _, position ->
            listAdapter.changeToIndex(position)
        }

        mBinding.rvList.run {
            itemAnimator = null
            setHasFixedSize(true)
            adapter = listAdapter
        }
        tabOneViewModel.getNextPage {
            listAdapter.setNewInstance(it)
        }

    }
}