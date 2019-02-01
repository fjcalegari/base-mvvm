package com.fjc.basemvvm.di.module

import com.fjc.basemvvm.ui.module.main.MainActivity
import com.fjc.basemvvm.ui.module.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity():MainActivity

}