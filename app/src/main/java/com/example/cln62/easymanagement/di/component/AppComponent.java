package com.example.cln62.easymanagement.di.component;

import com.example.cln62.easymanagement.di.module.AppModule;
import com.example.cln62.easymanagement.ui.login.LoginActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void injectAuthViewModel(LoginActivity loginActivity);

}
