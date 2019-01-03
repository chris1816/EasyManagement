package com.example.cln62.easymanagement.data

import com.example.cln62.easymanagement.data.network.NetworkHelper
import com.example.cln62.easymanagement.data.pojo.LoginInfo

class DataManager:IDataManager {

    companion object {
        val iNetworkHelper = NetworkHelper()
    }

    override fun login(listener: IDataManager.OnLoginListener, loginInfo: LoginInfo) {
        iNetworkHelper.login(listener, loginInfo)
    }
}