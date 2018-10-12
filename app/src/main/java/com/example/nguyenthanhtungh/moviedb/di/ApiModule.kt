package com.example.nguyenthanhtungh.moviedb.di

import com.example.nguyenthanhtungh.moviedb.BuildConfig
import com.example.nguyenthanhtungh.moviedb.data.source.remote.network.ApiService
import com.example.nguyenthanhtungh.moviedb.util.API_KEY_PARAM
import com.example.nguyenthanhtungh.moviedb.util.BASE_URL
import com.example.nguyenthanhtungh.moviedb.util.TIME_OUT
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Interceptor

import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module(override = true) {
    single { createHeaderInterceptor() }
    single { initOkHttpClient(get()) }
    single { initRetrofit(get()) }
    single { getApiService(get()) }
}

fun initOkHttpClient(header: Interceptor): OkHttpClient {
    val builder = OkHttpClient.Builder()
            .readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
            .connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
            .addInterceptor(header)
    return builder.build()
}

fun initRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}

private fun createHeaderInterceptor(): Interceptor {
    return Interceptor { chain ->
        val original = chain.request()
        val newUrl = original.url().newBuilder()
                .addQueryParameter(API_KEY_PARAM, BuildConfig.API_KEY)
                .build()
        val requestBuilder = original.newBuilder()
                .url(newUrl)
                .build()
        chain.proceed(requestBuilder)
    }
}

fun getApiService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}
