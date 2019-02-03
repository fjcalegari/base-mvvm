package com.fjc.basemvvm.ui.module.main

import android.arch.lifecycle.MutableLiveData
import android.os.Bundle
import android.util.Log
import com.fjc.basemvvm.ui.base.viewmodel.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel() {

    val countFab = MutableLiveData<Int>()

    init {
        Log.d("MainViewModel", "init")

    }

    override fun onFirsTimeUiCreate(bundle: Bundle?) {
        Log.d("MainViewModel", "onFirsTimeUiCreate")
    }

}