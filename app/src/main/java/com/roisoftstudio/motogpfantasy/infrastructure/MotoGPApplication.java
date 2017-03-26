package com.roisoftstudio.motogpfantasy.infrastructure;

import android.app.Application;

public class MotoGPApplication extends Application {

    private static MainComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mainComponent = DaggerMainComponent.builder().appModule(new AppModule(this)).build();
    }

    public static MainComponent component() {
        return mainComponent;
    }
}