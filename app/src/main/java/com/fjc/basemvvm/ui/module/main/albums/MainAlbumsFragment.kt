package com.fjc.basemvvm.ui.module.main.albums

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fjc.basemvvm.R
import com.fjc.basemvvm.databinding.FragmentMainAlbumsBinding
import com.fjc.basemvvm.ui.base.fragment.BaseViewModelFragment

class MainAlbumsFragment : BaseViewModelFragment<FragmentMainAlbumsBinding, MainAlbumsViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("MainAlbumsFragment", "onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("MainAlbumsFragment", "onActivityCreated")
    }

    companion object {

        fun newInstance() = MainAlbumsFragment().apply {
        }
    }

    override fun getViewModelClass(): Class<MainAlbumsViewModel> = MainAlbumsViewModel::class.java
    override fun getLayout(): Int = R.layout.fragment_main_albums

}