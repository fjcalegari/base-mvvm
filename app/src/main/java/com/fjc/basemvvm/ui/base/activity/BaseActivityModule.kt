package com.fjc.basemvvm.ui.base.activity

import android.app.Activity
import android.content.Context
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.fjc.basemvvm.di.qualifier.ActivityContext
import com.fjc.basemvvm.di.qualifier.ActivityFragmentManager
import dagger.Module
import dagger.Provides

@Module
abstract class BaseActivityModule<T: AppCompatActivity> {

    @Provides
    @ActivityContext
    fun provideContext(activity: T): Context = activity

    @Provides
    fun provideActivity(activity: T): Activity = activity

    @Provides
    @ActivityFragmentManager
    fun provideFragmentManager(activity: T): FragmentManager = activity.supportFragmentManager

}