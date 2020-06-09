package com.example.parayo.signin

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.parayo.api.ParayoApi
import com.example.parayo.api.request.SigninRequest
import com.example.parayo.api.request.SignupRequest
import com.example.parayo.api.response.ApiResponse
import com.example.parayo.api.response.SigninResponse
import com.example.parayo.common.Prefs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.codephobia.ankomvvm.lifecycle.BaseViewModel
import org.jetbrains.anko.error
import java.lang.Exception

/**
 * Created by KSW on 2020-06-09
 */

class SigninViewModel(app: Application) : BaseViewModel(app) {

    val email = MutableLiveData("")
    val password = MutableLiveData("")

    suspend fun signin() {
        val request = SigninRequest(email.value, password.value)
        if (isNotValidSignup(request))
            return
        try {
            val response = requsetSignin(request)
            onSigninResponse(response)
        } catch (e: Exception) {
            error("signup error", e)
            toast("알 수 없는 오류가 발생했습니다")
        }
    }

    // 요청 파라미터가 정확하게 입력되었는지를 검증
    private fun isNotValidSignup(signinRequest: SigninRequest) =
        when {
            signinRequest.isNotValidEmail() -> {
                toast("이메일 형식이 정확하지 않습니다.")
                true
            }
            signinRequest.isNotValidPassword() -> {
                toast("비밀번호는 8자 이상 20자 이하로 입력해주세요")
                true
            }
            else -> false
        }

    // 회원가입 API를 호출해주는 코드
    private suspend fun requsetSignin(request: SigninRequest) =
        withContext(Dispatchers.IO) {
            ParayoApi.instance.signin(request)
        }

    private fun onSigninResponse(response: ApiResponse<SigninResponse>) {
        if(response.success && response.data != null) {

            Prefs.token = response.data.token
            Prefs.refreshToken = response.data.refreshToken
            Prefs.userName = response.data.userName
            Prefs.userId = response.data.userId
            toast("로그인 되었습니다.")
//            finishActivity()
        } else {
            toast(response.message ?: "알 수 없는 오류가 발생했습니다.")
        }
    }
}