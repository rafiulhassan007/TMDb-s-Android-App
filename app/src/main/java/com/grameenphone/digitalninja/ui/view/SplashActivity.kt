package com.grameenphone.digitalninja.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.grameenphone.digitalninja.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            nextScreen()
        }, 2000)
    }

    private fun nextScreen() {
        finish()
        startActivity(Intent(this,HomeActivity::class.java))
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }
}