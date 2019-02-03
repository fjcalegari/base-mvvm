package com.fjc.basemvvm.ui.base.fragment

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.fjc.basemvvm.di.qualifier.ActivityContext
import com.fjc.basemvvm.di.qualifier.ActivityFragmentManager
import com.fjc.basemvvm.di.qualifier.ChildFragmentManager
import dagger.Module
import dagger.Provides

@Module
abstract class BaseFragmentModule<T: Fragment> {

    @Provides
    @ActivityContext
    fun provideContext(fragment: T): Context = fragment.context!!

    @Provides
    @ActivityFragmentManager
    fun provideActivityFragmentManager(activity: FragmentActivity): FragmentManager = activity.supportFragmentManager

    @Provides
    @ChildFragmentManager
    fun provideChildFragmentManager(fragment: T): FragmentManager {
        return fragment.childFragmentManager
    }

    @Provides
    fun provideActivity(fragment: T): FragmentActivity {
        return fragment.activity!!
    }

}