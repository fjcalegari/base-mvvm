package com.fjc.basemvvm

import android.app.Activity
import android.app.Application
import com.fjc.basemvvm.di.builder.AppInjector
import com.fjc.basemvvm.di.component.AppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class BaseApp: Application(), HasActivityInjector {

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityAndroidInjector
    }

    private lateinit var appComponent: AppComponent

    @Inject
    lateinit var activityAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        appComponent = AppInjector.init(this)

    }

}