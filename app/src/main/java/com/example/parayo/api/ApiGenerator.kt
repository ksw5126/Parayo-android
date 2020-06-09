package com.example.parayo.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by KSW on 2020-06-03
 */
class ApiGenerator {

    fun <T> generate(api: Class<T>): T = Retrofit.Builder()
        .baseUrl(HOST)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient())
        .build()
        .create(api)

    private fun httpClient() =
        OkHttpClient.Builder().apply {
            addInterceptor(httpLoggingInterceptor())
        }.build()

    private fun httpLoggingInterceptor() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    companion object {
        const val HOST = "https://192.168.6.9:8080"
//        const val HOST = "https://10.0.2.2:8080"
    }
}