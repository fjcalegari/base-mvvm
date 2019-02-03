package com.fjc.basemvvm.di.module

import com.fjc.basemvvm.data.remote.ServiceFactory
import com.fjc.basemvvm.data.remote.UsersApi
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun provideUsersApi() = ServiceFactory.makeService().create(UsersApi::class.java)

}