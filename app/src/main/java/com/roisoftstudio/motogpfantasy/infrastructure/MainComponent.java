package com.roisoftstudio.motogpfantasy.infrastructure;


import com.roisoftstudio.motogpfantasy.infrastructure.module.AppModule;
import com.roisoftstudio.motogpfantasy.ui.dashboard.DashboardActivity;
import com.roisoftstudio.motogpfantasy.ui.lastresults.LastResultsActivity;
import com.roisoftstudio.motogpfantasy.ui.login.LoginActivity;
import com.roisoftstudio.motogpfantasy.ui.myselection.SelectionActivity;
import com.roisoftstudio.motogpfantasy.ui.start.StartActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface MainComponent {
    void inject(DashboardActivity activity);
    void inject(StartActivity activity);
    void inject(LoginActivity activity);
    void inject(LastResultsActivity lastResultsActivity);
    void inject(SelectionActivity selectionActivity);
}
