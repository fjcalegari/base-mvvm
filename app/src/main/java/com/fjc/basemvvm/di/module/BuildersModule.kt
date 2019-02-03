package com.fjc.basemvvm.di.module

import com.fjc.basemvvm.ui.module.main.MainActivity
import com.fjc.basemvvm.ui.module.main.MainModule
import com.fjc.basemvvm.ui.module.main.albums.MainAlbumsFragment
import com.fjc.basemvvm.ui.module.main.albums.MainAlbumsModule
import com.fjc.basemvvm.ui.module.main.posts.MainPostsFragment
import com.fjc.basemvvm.ui.module.main.posts.MainPostsModule
import com.fjc.basemvvm.ui.module.main.users.MainUsersFragment
import com.fjc.basemvvm.ui.module.main.users.MainUsersModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun provideMainActivity():MainActivity

    @ContributesAndroidInjector(modules = [MainUsersModule::class])
    abstract fun provaideMainUsersFragment():MainUsersFragment

    @ContributesAndroidInjector(modules = [MainPostsModule::class])
    abstract fun provaideMainPostsFragment():MainPostsFragment

    @ContributesAndroidInjector(modules = [MainAlbumsModule::class])
    abstract fun provideMainAlbumsFragment():MainAlbumsFragment

}