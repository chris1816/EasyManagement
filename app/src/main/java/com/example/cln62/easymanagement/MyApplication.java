package com.example.cln62.easymanagement;

import android.app.Application;
import com.example.cln62.easymanagement.di.component.AppComponent;
import com.example.cln62.easymanagement.di.component.DaggerAppComponent;
import com.example.cln62.easymanagement.di.module.AppModule;

public class MyApplication extends Application {

    AppComponent myAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        myAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
    }

    public AppComponent getComponentInstance() {
        return myAppComponent;
    }
}
