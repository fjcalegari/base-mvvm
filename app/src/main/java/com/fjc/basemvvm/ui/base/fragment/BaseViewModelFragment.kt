package com.fjc.basemvvm.ui.base.fragment

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.View
import com.fjc.basemvvm.di.builder.Injectable
import com.fjc.basemvvm.ui.base.activity.BaseActivity
import com.fjc.basemvvm.ui.base.viewmodel.BaseViewModel
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
abstract class BaseViewModelFragment<B: ViewDataBinding, VM: BaseViewModel>: BaseFragment<B>(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.viewModel = ViewModelProviders.of(this, this.viewModelFactory).get(getViewModelClass())

        this.viewModel.onCreate(getFragmentArguments())
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity !is BaseActivity) {
            throw IllegalStateException("All fragment's container must extend BaseActivity")
        }
    }

    abstract fun getViewModelClass(): Class<VM>

}