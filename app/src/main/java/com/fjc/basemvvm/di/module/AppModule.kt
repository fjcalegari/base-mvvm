package com.fjc.basemvvm.di.module

import android.app.Application
import android.content.Context
import com.fjc.basemvvm.di.builder.ViewModelBuilder
import com.fjc.basemvvm.di.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelBuilder::class])
class AppModule {

    @Provides
    @Singleton
    @ApplicationContext
    internal fun provideApplicationContext(application: Application):Context = application

}