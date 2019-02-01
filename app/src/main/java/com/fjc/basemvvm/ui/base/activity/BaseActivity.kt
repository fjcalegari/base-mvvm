package com.fjc.basemvvm.ui.base.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity: AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Fragment>
    override fun supportFragmentInjector() = androidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayout())
    }

    abstract fun getLayout(): Int

}