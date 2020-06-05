package com.example.parayo.api

import com.example.parayo.api.response.ApiResponse
import retrofit2.http.GET

/**
 * Created by KSW on 2020-06-03
 */

interface ParayoApi {

    @GET("/api/v1/hello")
    suspend fun hello(): ApiResponse<String>

    companion object {
        val instance = ApiGenerator()
            .generate(ParayoApi::class.java)
    }
}