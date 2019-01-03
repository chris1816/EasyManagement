package com.example.cln62.easymanagement.data

import com.example.cln62.easymanagement.data.network.INetworkHelper
import com.example.cln62.easymanagement.data.pojo.LoginUserInfo

interface IDataManager: INetworkHelper {

    interface OnLoginListener{
        fun getUserInfo(result: LoginUserInfo)
        fun errorMsg(msg:String)
    }
}