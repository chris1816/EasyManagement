package com.example.cln62.easymanagement.data

import com.example.cln62.easymanagement.data.network.NetworkHelper
import com.example.cln62.easymanagement.data.pojo.LoginInfo
import com.example.cln62.easymanagement.data.pojo.SignupInfo

class DataManager:IDataManager {

    companion object {
        val iNetworkHelper = NetworkHelper()
    }

    override fun signup(listener: IDataManager.OnSignupListener, signupInfo: SignupInfo) {
        iNetworkHelper.signup(listener, signupInfo)
    }

    override fun login(listener: IDataManager.OnLoginListener, loginInfo: LoginInfo) {
        iNetworkHelper.login(listener, loginInfo)
    }
}