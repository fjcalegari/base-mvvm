package com.fjc.basemvvm.di.builder

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.fjc.basemvvm.BaseApp
import com.fjc.basemvvm.di.component.AppComponent
import com.fjc.basemvvm.di.component.DaggerAppComponent
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector

interface Injectable

fun initInjector(baseApp: BaseApp): AppComponent {
    var appComponent = DaggerAppComponent.builder()
        .application(baseApp)
        .build()

    appComponent.inject(baseApp)

    baseApp.registerActivityLifecycleCallbacks(
        object : Application.ActivityLifecycleCallbacks {

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                handleActivity(activity)
            }

            override fun onActivityStarted(activity: Activity) {

            }

            override fun onActivityResumed(activity: Activity) {

            }

            override fun onActivityPaused(activity: Activity) {

            }

            override fun onActivityStopped(activity: Activity) {

            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {

            }

            override fun onActivityDestroyed(activity: Activity) {

            }
        })

    return appComponent
}

private fun handleActivity(activity: Activity) {
  if (activity is Injectable || activity is HasSupportFragmentInjector) {
    AndroidInjection.inject(activity)
  }
  if (activity is FragmentActivity) {
    activity.supportFragmentManager.registerFragmentLifecycleCallbacks(
        object : FragmentManager.FragmentLifecycleCallbacks() {
          override fun onFragmentCreated(fm: FragmentManager, f: Fragment, s: Bundle?) {
            if (f is Injectable) {
              AndroidSupportInjection.inject(f)
            }
          }
        }, true)
  }
}
