package com.roisoftstudio.motogpfantasy.infrastructure;

import android.app.Application;

import com.roisoftstudio.motogpfantasy.infrastructure.module.AppModule;

public class Injector {

    private static MainComponent mainComponent;

    public static void inject(Application application){
        mainComponent = DaggerMainComponent.builder().appModule(new AppModule(application)).build();
    }
    public static MainComponent component() {
        return mainComponent;
    }

}
