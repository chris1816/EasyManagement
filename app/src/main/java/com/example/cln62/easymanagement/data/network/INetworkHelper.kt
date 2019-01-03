package com.example.cln62.easymanagement.data.network

import com.example.cln62.easymanagement.data.IDataManager
import com.example.cln62.easymanagement.data.pojo.LoginInfo

interface INetworkHelper {

    fun login(listener: IDataManager.OnLoginListener, loginInfo: LoginInfo)
}