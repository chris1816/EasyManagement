package com.example.cln62.easymanagement.network

import com.example.cln62.easymanagement.data.IDataManager
import com.example.cln62.easymanagement.data.model.LoginInfo
import com.example.cln62.easymanagement.data.model.SignupInfo

interface INetworkHelper {

    fun login(listener: IDataManager.OnLoginListener, loginInfo: LoginInfo)

    fun signup(listener: IDataManager.OnSignupListener, signupInfo: SignupInfo)
}