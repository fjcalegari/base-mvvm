package com.fjc.basemvvm.di.builder

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.fjc.basemvvm.ui.module.main.MainViewModel
import com.fjc.basemvvm.ui.module.main.albums.MainAlbumsViewModel
import com.fjc.basemvvm.ui.module.main.posts.MainPostsViewModel
import com.fjc.basemvvm.ui.module.main.users.MainUsersViewModel
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
    @IntoMap
    @ViewModelKey(MainUsersViewModel::class)
    abstract fun bindMainUsersViewModel(viewModel: MainUsersViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainPostsViewModel::class)
    abstract fun bindMainPostsViewModel(viewModel: MainPostsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainAlbumsViewModel::class)
    abstract fun bindMainAlbumsViewModel(viewModel: MainAlbumsViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory( factory: AppViewModelFactory):
            ViewModelProvider.Factory

}