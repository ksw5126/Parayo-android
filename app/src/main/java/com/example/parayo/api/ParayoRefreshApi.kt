package com.example.parayo.api

import com.example.parayo.api.response.ApiResponse
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by KSW on 2020-08-25
 */

interface ParayoRefreshApi {

    @POST("/api/v1/refresh_token")
    suspend fun refreshToken(
        @Query("grant_type") grantType : String = "refresh_token"
    ) : ApiResponse<String>

    companion object {
        val instance = ApiGenerator()
            .generateRefreshClient(ParayoRefreshApi::class.java)
    }
}