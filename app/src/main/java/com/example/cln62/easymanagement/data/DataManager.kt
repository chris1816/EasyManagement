package com.example.cln62.easymanagement.data

import com.example.cln62.easymanagement.network.NetworkHelper

import com.example.cln62.easymanagement.data.pojo.LoginInfo
import com.example.cln62.easymanagement.data.pojo.SignupInfo
import com.example.cln62.easymanagement.data.pojo.projectpojo.ProjectsItem

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

    override fun getProjectList(listener: IDataManager.OnProjectListListener) {
        iNetworkHelper.getProjectList(listener)
    }

    override fun updateProject(listener: IDataManager.OnProjectListListener, p: ProjectsItem, index: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}