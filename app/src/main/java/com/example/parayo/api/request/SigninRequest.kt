package com.example.parayo.api.request

import android.util.Patterns

/**
 * Created by KSW on 2020-06-09
 */

class SigninRequest(
    val email: String?,
    val password: String?
) {

    fun isNotValidEmail() =
        email.isNullOrBlank() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun isNotValidPassword() =
        password.isNullOrBlank() || password.length !in 8..20

}