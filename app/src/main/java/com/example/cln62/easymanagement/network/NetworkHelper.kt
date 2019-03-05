package com.example.cln62.easymanagement.network

import android.util.Log
import com.example.cln62.easymanagement.data.IDataManager
import com.example.cln62.easymanagement.data.pojo.LoginInfo
import com.example.cln62.easymanagement.data.pojo.SignupInfo
import com.example.cln62.easymanagement.data.pojo.projectpojo.ProjectsItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.warn

class NetworkHelper : INetworkHelper {

    private val SIGNUP_TAG = AnkoLogger("signup")

    private val LOGIN_TAG = AnkoLogger("Login")
    var disposable: Disposable? = null
    val apiService by lazy {
        ApiService.create()
    }

    override fun signup(listener: IDataManager.OnSignupListener, signupInfo: SignupInfo) {
        disposable = apiService.signup(
            signupInfo.fname,
            signupInfo.lname,
            signupInfo.email,
            signupInfo.mobile,
            signupInfo.password,
            signupInfo.compSize,
            signupInfo.role)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                if (result.msg?.get(0).equals("successfully registered")) {
                    SIGNUP_TAG.warn { "registered user " + signupInfo.toString()  }
                    listener.isSignuped(true)
                } else {
                    SIGNUP_TAG.warn { result.toString() }
                    listener.isSignuped(false)
                }
            }, { error -> SIGNUP_TAG.warn { error.message }})
    }

    override fun login(listener: IDataManager.OnLoginListener, loginInfo: LoginInfo) {

        disposable = apiService.login(
            loginInfo.email,
            loginInfo.password
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                LOGIN_TAG.warn { "yes " + result.msg }
                listener.getUserInfo(result)
                }, { error ->
                    LOGIN_TAG.warn { "no" + error.message }
                    }
            )
    }

    override fun getProjectList(listener: IDataManager.OnProjectListListener) {
        disposable =
                apiService.getProjectList()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        { result ->
                            for (item in result.projects!!) {
                                item as ProjectsItem
                                //if(!item.projectstatus.equals("2") ){
                                listener.finishedInitialList(item)
                                //}
                            }
                            Log.d("getProjectList", (result.projects.size.toString())
                            )
                        },
                        { error -> Log.d("getProjectList", error.message) }
                    )    }

    override fun updateProject(listener: IDataManager.OnProjectListListener, p: ProjectsItem, index: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}