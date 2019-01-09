package com.example.cln62.easymanagement.data.network

import android.util.Log
import com.example.cln62.easymanagement.data.IDataManager
import com.example.cln62.easymanagement.data.pojo.LoginInfo
import com.example.cln62.easymanagement.data.pojo.SignupInfo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.warn

class NetworkHelper : INetworkHelper {

    private val SIGNUP_TAG = AnkoLogger("signup")

    override fun signup(listener: IDataManager.OnSignupListener, signupInfo: SignupInfo) {
        disposable = apiService.signup(
            signupInfo.fname,
            signupInfo.lname,
            signupInfo.email,
            signupInfo.mobile,
            signupInfo.password,
            signupInfo.compSize,
            signupInfo.role)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                if (result.msg!!.get(0).equals("successfully registered")) {
                    SIGNUP_TAG.warn { "registered user " + signupInfo.toString()  }
                    listener.isSignuped(true)
                } else {
                    SIGNUP_TAG.warn { result.toString() }
                    listener.isSignuped(false)
                }
            }, { error -> SIGNUP_TAG.warn { error.message }})
    }

    private val LOGIN_TAG = AnkoLogger("Login")
    var disposable: Disposable? = null
    val apiService by lazy {
        ApiService.create()
    }

    override fun login(listener: IDataManager.OnLoginListener, loginInfo: LoginInfo) {

        disposable = apiService.login(
            loginInfo.email!!,
            loginInfo.password!!
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                LOGIN_TAG.warn { result.msg } //result.msg
                listener.getUserInfo(result)
            }, { error ->
                LOGIN_TAG.warn { error.message }
            })
    }

}