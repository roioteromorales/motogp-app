package com.roisoftstudio.motogpfantasy;

import android.app.Application;
import android.support.annotation.VisibleForTesting;

import com.roisoftstudio.motogpfantasy.infrastructure.AppModule;
import com.roisoftstudio.motogpfantasy.infrastructure.DaggerMainComponent;
import com.roisoftstudio.motogpfantasy.infrastructure.MainComponent;

public class MotoGPApplication extends Application {

    private static MainComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mainComponent = DaggerMainComponent.builder().appModule(new AppModule()).build();
    }

    public static MainComponent component() {
        return mainComponent;
    }

    public MainComponent getMainComponent() {
        return mainComponent;
    }

    @VisibleForTesting
    public void setComponent(MainComponent mainComponent) {
        this.mainComponent = mainComponent;
    }
}