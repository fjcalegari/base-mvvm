package com.fjc.basemvvm.ui.module.main

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.fjc.basemvvm.ui.base.viewmodel.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel() {

    val countFab = MutableLiveData<Int>()

    init {
        Log.d("MainViewModel", "init")

        countFab.value = 0
    }

    fun onClickFab() {
        countFab.value = countFab.value?.plus(1)
    }

}