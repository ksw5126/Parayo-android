package com.example.parayo.product

import android.app.Application
import android.content.Intent
import com.example.parayo.product.registration.ProductRegistrationActivity
import net.codephobia.ankomvvm.lifecycle.BaseViewModel

/**
 * Created by KSW on 2020-08-24
 */

class ProductMainViewModel(app: Application) : BaseViewModel(app) {
    fun openRegistrationActivity() {
        startActivity<ProductRegistrationActivity> {
            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        }
    }
}