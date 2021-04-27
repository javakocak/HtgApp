package com.eraykocak.htgapp.api

import com.eraykocak.htgapp.model.ResponsePin
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ServiceHexTech {
    val BASE_URL="https://app.hextechgreen.com/"

    private val client = OkHttpClient()

    private var api= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(client)
        .build()
        .create(testApi::class.java)

    fun getHexPin(): Call<ResponsePin> {
        return api.getPinList()
    }

}