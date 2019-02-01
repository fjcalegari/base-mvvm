package com.fjc.basemvvm.ui.base.activity

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import com.fjc.basemvvm.ui.base.viewmodel.BaseViewModel
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
abstract class BaseViewModelActivity<B: ViewDataBinding, VM: BaseViewModel>: BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: VM

    lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.binding = DataBindingUtil.setContentView(this, getLayout())

        val viewModelClass: Class<VM> = ((javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[1]) as Class<VM>
        this.viewModel = ViewModelProviders.of(this, this.viewModelFactory).get(viewModelClass)

        this.viewModel.onCreate(intent.extras)
    }

}