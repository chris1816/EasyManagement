package com.example.cln62.easymanagement.network

import com.example.cln62.easymanagement.data.pojo.LoginUserInfo
import com.example.cln62.easymanagement.data.pojo.SuccessMsg
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object {

        val BASEURL:String = "http://rjtmobile.com/"

        fun create(): ApiService {

            val retrofit = Retrofit.Builder()
                .baseUrl(BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }

    @GET("aamir/pms/android-app/pms_login.php?")
    fun login(@Query("email") email:String,
              @Query("password") password:String): Observable<LoginUserInfo>

    @GET("aamir/pms/android-app/pms_reg.php")
    fun signup(@Query("first_name") fname: String,
               @Query("last_name") lname: String,
               @Query("email") email: String,
               @Query("mobile") mobile: String,
               @Query("password") password: String,
               @Query("company_size") company_size: String,
               @Query("your_role") role: String): Observable<SuccessMsg>

}