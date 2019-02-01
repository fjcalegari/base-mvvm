package com.fjc.basemvvm.ui.base.viewmodel

import android.arch.lifecycle.ViewModel
import android.os.Bundle
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    val compositeDisposable = CompositeDisposable()

    fun onCreate(bundle: Bundle?) {

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun addDisposable(disposable: Disposable) = compositeDisposable.add(disposable)

}