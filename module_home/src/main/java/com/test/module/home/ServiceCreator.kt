package com.test.module.home

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ServiceCreator {
    private const val BASE_URL = "http://baobab.kaiyanapp.com/"

    private val retrofit= Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>):T= retrofit.create(serviceClass)

    inline fun <reified T> create():T= create(T::class.java)
}