package com.fjc.basemvvm.data.remote

import com.fjc.basemvvm.data.model.User
import io.reactivex.Single
import retrofit2.http.GET

//Users API Service Interface
interface UsersApi {

    @GET("users")
    fun getUsersList(): Single<List<User>>

}