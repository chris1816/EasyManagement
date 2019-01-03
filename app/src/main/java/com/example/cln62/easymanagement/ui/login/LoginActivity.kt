package com.example.cln62.easymanagement.ui.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.cln62.easymanagement.R
import com.example.cln62.easymanagement.data.IDataManager
import com.example.cln62.easymanagement.data.pojo.LoginInfo
import com.example.cln62.easymanagement.data.pojo.LoginUserInfo
import com.example.cln62.easymanagement.viewmodel.AuthenticationViewModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.content_login.*
import org.jetbrains.anko.toast

class LoginActivity : AppCompatActivity(), IDataManager.OnLoginListener {

    val viewModel = AuthenticationViewModel()

    override fun getUserInfo(userInfo: LoginUserInfo) {
        toast("Login Success")
        val bundle = Bundle()
        bundle.putParcelable("userInfo", userInfo)
        val role = userInfo.userrole

    }

    override fun errorMsg(msg: String) {
        //anko extension
        toast(msg)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //synthetic binding
        setSupportActionBar(toolbar)

        btn_login.setOnClickListener {
            getUserInput()
        }
    }

    private fun getUserInput() {
        var email = et_login_email.text.toString()
        var password = et_login_pw.text.toString()
        val loginInfo = LoginInfo(email = email, password = password)
        viewModel.login(this, loginInfo)
    }
}
