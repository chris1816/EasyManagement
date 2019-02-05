package com.example.cln62.easymanagement.ui.signup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.cln62.easymanagement.R
import com.example.cln62.easymanagement.data.DataManager
import com.example.cln62.easymanagement.data.IDataManager
import com.example.cln62.easymanagement.data.pojo.SignupInfo
import kotlinx.android.synthetic.main.activity_signup.*
import org.jetbrains.anko.toast

class SignupActivity : AppCompatActivity(), IDataManager.OnSignupListener{

    override fun isSignuped(boolean: Boolean) {
        Log.d("signup_act_tag", boolean.toString())
        if (boolean) {
            toast("Successfully Registered")
            onBackPressed()
        } else {
            toast("Registration Failed. Please try again")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        bt_register.setOnClickListener {
            val signup = SignupInfo(
                fname = et_registerFname.text.toString(),
                lname = et_registerLname.text.toString(),
                email = et_registerEmail.text.toString(),
                mobile = et_registerMobile.text.toString(),
                password = et_registerPass.text.toString(),
                compSize = et_registerCompSize.text.toString(),
                role = et_registerRole.text.toString()
            )

            Log.d("SignupTag", "SignupActivity: " + signup.toString())

            val iDataManager: IDataManager = DataManager()
            iDataManager.signup(this, signup)

        }
    }
}
