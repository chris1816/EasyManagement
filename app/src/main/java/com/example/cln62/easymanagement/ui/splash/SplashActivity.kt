package com.example.cln62.easymanagement.ui.splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.example.cln62.easymanagement.R
//import com.example.cln62.easymanagement.R
import com.example.cln62.easymanagement.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splashText  = tv_splash
        val animation = AnimationUtils.loadAnimation(this, R.anim.fade)

        val thread = object : Thread() {
            override fun run() {
                super.run()
                try {
                    Thread.sleep(4000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

                val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }

        thread.start()
    }
}
