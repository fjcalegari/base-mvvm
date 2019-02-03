package com.fjc.basemvvm.ui.module.main.albums

import android.os.Bundle
import android.util.Log
import com.fjc.basemvvm.ui.base.viewmodel.BaseViewModel
import javax.inject.Inject

class MainAlbumsViewModel @Inject constructor() : BaseViewModel() {

    init {
        Log.d("MainAlbumsViewModel", "init")
    }

    override fun onFirsTimeUiCreate(bundle: Bundle?) {
        Log.d("MainAlbumsViewModel", "onFirsTimeUiCreate")
    }

}