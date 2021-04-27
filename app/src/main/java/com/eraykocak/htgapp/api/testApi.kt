package com.eraykocak.htgapp.api

import android.telecom.Call
import com.eraykocak.htgapp.model.ResponsePin
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface testApi {

    @GET("/mini/test")
    fun getPinList(): retrofit2.Call<ResponsePin>

}