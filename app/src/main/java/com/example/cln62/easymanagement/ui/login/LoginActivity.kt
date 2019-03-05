package com.example.cln62.easymanagement.ui.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.cln62.easymanagement.BuildConfig
import com.example.cln62.easymanagement.MyApplication
import com.example.cln62.easymanagement.R
import com.example.cln62.easymanagement.data.IDataManager
import com.example.cln62.easymanagement.data.pojo.LoginInfo
import com.example.cln62.easymanagement.data.pojo.LoginUserInfo
import com.example.cln62.easymanagement.ui.main.MainActivity
import com.example.cln62.easymanagement.ui.signup.SignupActivity
import com.example.cln62.easymanagement.viewmodel.AuthenticationViewModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.content_login.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), IDataManager.OnLoginListener {

    @Inject
    internal lateinit var authenticationViewModel: AuthenticationViewModel

    override fun getUserInfo(result: LoginUserInfo) {
        val role = result.userrole
        toast("Login Success， user role $role")
        val bundle = Bundle()
        bundle.putParcelable("userInfo", result)

        if (BuildConfig.FLAVOR.equals("manager")) {
            if (role == "admin") {
                intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent, bundle)
            } else {
                toast("This is not a Manager Account, please log in with manager email")
            }

            toast("This is not a Manager Account, please log in with manager email")

        } else if (BuildConfig.FLAVOR.equals("developer")) {
            if (role == "user") {
                intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent, bundle)
            } else {
                toast("This is not a Developer Account, please log in with developer email")
            }
        }
    }

    override fun errorMsg(msg: String) {
        //anko extension
        toast(msg)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
//        (getApplicationContext() as MyApplication).getComponentInstance().injectAuthViewModel(this)
        (applicationContext as MyApplication).componentInstance.injectAuthViewModel(this)

        //synthetic binding
        setSupportActionBar(toolbar)

        btn_login.setOnClickListener {
            getUserInput()
        }

        tv_gotoSignup.setOnClickListener {
            //            val intent:Intent = Intent(Signu)
            intent = Intent(this@LoginActivity, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getUserInput() {
        val email = et_login_email.text.toString()
        val password = et_login_pw.text.toString()
        val loginInfo = LoginInfo(email = email, password = password)
        authenticationViewModel.login(this, loginInfo)
    }
}
