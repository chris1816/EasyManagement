package com.example.cln62.easymanagement.di.module;

import com.example.cln62.easymanagement.viewmodel.AuthenticationViewModel;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class AppModule {

    @Singleton
    @Provides
    public AuthenticationViewModel getAuthViewModel() {
        return new AuthenticationViewModel();
    }
}
