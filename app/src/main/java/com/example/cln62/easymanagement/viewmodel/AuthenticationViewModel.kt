package com.example.cln62.easymanagement.viewmodel

import android.databinding.BaseObservable
import com.example.cln62.easymanagement.data.DataManager
import com.example.cln62.easymanagement.data.IDataManager
import com.example.cln62.easymanagement.data.model.LoginInfo


class AuthenticationViewModel:BaseObservable(){

    val dataManager: IDataManager = DataManager()

    fun login(listener:IDataManager.OnLoginListener,loginInfo: LoginInfo){
        dataManager.login(listener, loginInfo)

    }

}