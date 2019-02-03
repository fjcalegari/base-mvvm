package com.fjc.basemvvm.data.remote

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ServiceFactory {

    companion object {

        @JvmStatic
        fun makeService(): Retrofit {
            return retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(RemoteConstants.BASE_URL)
                .build()
        }
    }

}