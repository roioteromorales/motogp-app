package com.roisoftstudio.motogpfantasy.infrastructure;


import com.roisoftstudio.motogpfantasy.ui.dashboard.DashboardActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton @Component(modules = {AppModule.class}) public interface MainComponent {
  void inject(DashboardActivity activity);
}
