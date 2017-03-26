package com.roisoftstudio.motogpfantasy.infrastructure;


import com.roisoftstudio.motogpfantasy.ui.dashboard.DashboardActivity;
import com.roisoftstudio.motogpfantasy.ui.start.StartActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton @Component(modules = {AppModule.class}) public interface MainComponent {
  void inject(DashboardActivity activity);
  void inject(StartActivity activity);
}
