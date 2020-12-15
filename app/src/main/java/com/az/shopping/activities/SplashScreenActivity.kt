package com.az.shopping.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.az.shopping.MainActivity
import com.az.shopping.R
import com.az.shopping.constants.AppConstants
import com.az.shopping.constants.getSharedPref

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        if (AppConstants.SP_CURRENT_USER.getSharedPref(this, "No") == "No") {
            startActivity(Intent(this, LoginActivity::class.java))
        } else {
            startActivity(Intent(this, MainActivity::class.java))
        }
        finish()
    }
}