package com.example.parayo.api

import com.example.parayo.api.request.SigninRequest
import com.example.parayo.api.request.SignupRequest
import com.example.parayo.api.response.ApiResponse
import com.example.parayo.api.response.SigninResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

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

    @POST("/api/v1/users")
    suspend fun signup(@Body signupRequest: SignupRequest)
        : ApiResponse<Void>

    @POST("api/v1/signin")
    suspend fun signin(@Body signinRequest: SigninRequest)
         : ApiResponse<SigninResponse>
}