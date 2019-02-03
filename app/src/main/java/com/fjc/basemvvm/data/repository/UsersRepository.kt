package com.fjc.basemvvm.data.repository

import com.fjc.basemvvm.data.model.User
import com.fjc.basemvvm.data.remote.UsersApi
import io.reactivex.Single
import javax.inject.Inject

class UsersRepository @Inject
    constructor(
        private val usersApi: UsersApi
) {

    fun getUsersList(): Single<List<User>> = usersApi.getUsersList()

}