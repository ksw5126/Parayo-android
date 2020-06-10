package com.example.parayo.intro

import android.app.Activity
import android.os.Bundle
import com.example.parayo.signin.SigninActivity
import com.example.parayo.signup.SignupActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity

class IntroActivity : Activity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        IntroActivityUI().setContentView(this)

        GlobalScope.launch {
            delay(1000)
            startActivity<SignupActivity>()
            finish()
        }

    }


}