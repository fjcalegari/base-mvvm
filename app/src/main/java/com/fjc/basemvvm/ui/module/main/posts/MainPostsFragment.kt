package com.fjc.basemvvm.ui.module.main.posts

import android.os.Bundle
import android.util.Log
import android.view.View
import com.fjc.basemvvm.R
import com.fjc.basemvvm.databinding.FragmentMainPostsBinding
import com.fjc.basemvvm.databinding.FragmentMainUsersBinding
import com.fjc.basemvvm.ui.base.fragment.BaseViewModelFragment

class MainPostsFragment : BaseViewModelFragment<FragmentMainPostsBinding, MainPostsViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("MainPostsFragment", "onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("MainPostsFragment", "onActivityCreated")
    }

    companion object {

        fun newInstance() = MainPostsFragment().apply {
        }
    }

    override fun getViewModelClass(): Class<MainPostsViewModel> = MainPostsViewModel::class.java
    override fun getLayout(): Int = R.layout.fragment_main_posts

}