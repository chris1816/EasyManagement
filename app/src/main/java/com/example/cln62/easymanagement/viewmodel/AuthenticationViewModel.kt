package com.example.cln62.easymanagement.viewmodel

import android.databinding.BaseObservable
import android.util.Log
import com.example.cln62.easymanagement.data.DataManager
import com.example.cln62.easymanagement.data.IDataManager
import com.example.cln62.easymanagement.data.pojo.LoginInfo
import com.example.cln62.easymanagement.ui.base.BaseViewModel
import org.jetbrains.anko.toast


class AuthenticationViewModel:BaseObservable(){

    val dataManager: IDataManager = DataManager()

    fun login(listener:IDataManager.OnLoginListener,loginInfo: LoginInfo){
        dataManager.login(listener, loginInfo)

    }

}