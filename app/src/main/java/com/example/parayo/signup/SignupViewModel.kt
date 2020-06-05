package com.example.parayo.signup

import android.app.Application
import androidx.lifecycle.MutableLiveData
import net.codephobia.ankomvvm.lifecycle.BaseViewModel

/**
 * Created by KSW on 2020-06-04
 */

// BaseViewModel 오류

class SignupViewModel(app: Application) : BaseViewModel(app) {
    val email = MutableLiveData("")
    val name = MutableLiveData("")
    val password = MutableLiveData("")

}