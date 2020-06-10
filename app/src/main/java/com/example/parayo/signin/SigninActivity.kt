package com.example.parayo.signin

import android.os.Bundle
import net.codephobia.ankomvvm.components.BaseActivity
import org.jetbrains.anko.setContentView

/**
 * Created by KSW on 2020-06-09
 */

class SigninActivity : BaseActivity<SigninViewModel>() {

    override val viewModelType = SigninViewModel::class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SigninActivityUI(getViewModel())
            .setContentView(this)
    }
}