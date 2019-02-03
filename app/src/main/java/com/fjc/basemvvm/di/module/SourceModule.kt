package com.fjc.basemvvm.di.module

import com.fjc.basemvvm.data.remote.UsersApi
import com.fjc.basemvvm.data.repository.UsersRepository
import dagger.Module
import dagger.Provides

@Module
class SourceModule {

    @Provides
    fun provideUsersRepository(usersApi: UsersApi) = UsersRepository(usersApi)

}