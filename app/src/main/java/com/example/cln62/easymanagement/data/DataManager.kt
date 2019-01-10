package com.example.cln62.easymanagement.data

import com.example.cln62.easymanagement.network.NetworkHelper
import com.example.cln62.easymanagement.data.model.LoginInfo
import com.example.cln62.easymanagement.data.model.SignupInfo

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