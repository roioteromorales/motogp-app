package com.roisoftstudio.motogpfantasy.infrastructure;

import android.app.Application;

import com.roisoftstudio.motogpfantasy.infrastructure.module.AppModule;

import timber.log.Timber;

public class MotoGPApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Injector.inject(this);
        Timber.plant(new Timber.DebugTree());
    }

}