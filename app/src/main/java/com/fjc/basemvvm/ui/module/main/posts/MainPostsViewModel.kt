package com.fjc.basemvvm.ui.module.main.posts

import android.os.Bundle
import android.util.Log
import com.fjc.basemvvm.ui.base.viewmodel.BaseViewModel
import javax.inject.Inject

class MainPostsViewModel @Inject constructor() : BaseViewModel() {

    init {
        Log.d("MainPostsViewModel", "init")
    }

    override fun onFirsTimeUiCreate(bundle: Bundle?) {
        Log.d("MainPostsViewModel", "onFirsTimeUiCreate")
    }

}