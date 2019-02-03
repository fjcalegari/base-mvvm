package com.fjc.basemvvm.ui.base.viewmodel

import android.arch.lifecycle.ViewModel
import android.os.Bundle
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private var isFirstTimeUiCreate = true

    fun onCreate(bundle: Bundle?) {
        if (isFirstTimeUiCreate) {
            onFirsTimeUiCreate(bundle)
            isFirstTimeUiCreate = false
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    protected abstract fun onFirsTimeUiCreate(bundle:Bundle?)

    fun addDisposable(disposable: Disposable) = compositeDisposable.add(disposable)

}