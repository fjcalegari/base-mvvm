package com.fjc.basemvvm.di.builder

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.fjc.basemvvm.ui.module.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory( factory: AppViewModelFactory):
            ViewModelProvider.Factory

}