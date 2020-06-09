package com.example.parayo.api.response

/**
 * Created by KSW on 2020-06-09
 */

data class SigninResponse(
    val token: String,
    val refreshToken: String,
    val userName: String,
    val userId: Long
)