package com.example.parayo.signup

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.parayo.api.ParayoApi
import com.example.parayo.api.request.SignupRequest
import com.example.parayo.api.response.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.codephobia.ankomvvm.lifecycle.BaseViewModel
import org.jetbrains.anko.error
import java.lang.Exception

/**
 * Created by KSW on 2020-06-04
 */

// 뷰와 모델간의 연결고리역할하는 클래스
class SignupViewModel(app: Application) : BaseViewModel(app) {
    val email = MutableLiveData("")
    val name = MutableLiveData("")
    val password = MutableLiveData("")

    suspend fun signup() {
        val request = SignupRequest(email.value, password.value, name.value)
        if (isNotValidSignup(request))
            return
        try {
            val response = requsetSignup(request)
            onSignupResponse(response)
        } catch (e: Exception) {
            error("signup error", e)
            toast("알 수 없는 오류가 발생했습니다")
        }
    }

    // 요청 파라미터가 정확하게 입력되었는지를 검증
    private fun isNotValidSignup(signupRequest: SignupRequest) =
        when {
            signupRequest.isNotValidEmail() -> {
                toast("이메일 형식이 정확하지 않습니다.")
                true
            }
            signupRequest.isNotValidPassword() -> {
                toast("비밀번호는 8자 이상 20자 이하로 입력해주세요")
                true
            }
            signupRequest.isNotValidName() -> {
                toast("이름은 2자 이상 20자 이하로 입력해주세요")
                true
            }
            else -> false
        }

    // 회원가입 API를 호출해주는 코드
    private suspend fun requsetSignup(request: SignupRequest) =
        withContext(Dispatchers.IO) {
            ParayoApi.instance.signup(request)
        }

    private fun onSignupResponse(response: ApiResponse<Void>) {
        if(response.success) {
            toast("회원 가입이 되었습니다. 로그인 후 이용해주세요.")
            finishActivity()
        } else {
            toast(response.message ?: "알 수 없는 오류가 발생했습니다.")
        }
    }
}