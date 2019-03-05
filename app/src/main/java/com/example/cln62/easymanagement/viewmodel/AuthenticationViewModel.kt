package com.example.cln62.easymanagement.viewmodel

import com.example.cln62.easymanagement.data.DataManager
import com.example.cln62.easymanagement.data.IDataManager
import com.example.cln62.easymanagement.data.pojo.LoginInfo
import com.example.cln62.easymanagement.data.pojo.SignupInfo


class AuthenticationViewModel/*:BaseObservable()*/{

    val dataManager: IDataManager = DataManager()

    fun login(listener:IDataManager.OnLoginListener,loginInfo: LoginInfo){
        dataManager.login(listener, loginInfo)
    }

    fun signup(listener: IDataManager.OnSignupListener, signupInfo: SignupInfo) {
        dataManager.signup(listener, signupInfo)
    }

}