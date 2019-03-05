package com.example.cln62.easymanagement.data

import com.example.cln62.easymanagement.network.INetworkHelper
import com.example.cln62.easymanagement.data.pojo.LoginUserInfo
import com.example.cln62.easymanagement.data.pojo.projectpojo.ProjectsItem

interface IDataManager: INetworkHelper {

    interface OnLoginListener{
        fun getUserInfo(result: LoginUserInfo)
        fun errorMsg(msg:String)
    }

    interface OnSignupListener{
        fun isSignuped(boolean: Boolean)
    }

    interface OnCreateProjectListener{
        fun finishedOnCreateProject(p: ProjectsItem)
    }

    interface OnProjectListListener{
        fun finishedInitialList(item:ProjectsItem)
        fun finishedUpdateProject(p: ProjectsItem,
                                  index:Int)
    }
}