package com.fjc.basemvvm.di.component

import android.app.Application
import com.fjc.basemvvm.BaseApp
import com.fjc.basemvvm.di.module.AppModule
import com.fjc.basemvvm.di.module.BuildersModule
import com.fjc.basemvvm.di.module.NetworkModule
import com.fjc.basemvvm.di.module.SourceModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        AppModule::class,
        BuildersModule::class,
        NetworkModule::class,
        SourceModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: BaseApp)

}