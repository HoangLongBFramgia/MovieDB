package com.example.nguyenthanhtungh.moviedb.network

import com.example.nguyenthanhtungh.moviedb.util.BASE_URL
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private var sRetrofit: Retrofit? = null
    private var sOkHttpClient: OkHttpClient? = null

    val client: Retrofit?
        get() {
            if (sOkHttpClient == null) {
                initOkHttpClient()
            }
            if (sRetrofit == null) {
                initRetrofit()
            }
            return sRetrofit
        }

    private fun initRetrofit() {
        sRetrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(sOkHttpClient!!)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    private fun initOkHttpClient() {
        val builder = OkHttpClient.Builder()
                .readTimeout(12000, TimeUnit.MILLISECONDS)
                .connectTimeout(12000, TimeUnit.MILLISECONDS)
                .writeTimeout(12000, TimeUnit.MILLISECONDS)
        sOkHttpClient = builder.build()
    }
}
