package com.roisoftstudio.motogpfantasy.infrastructure;


import com.roisoftstudio.motogpfantasy.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton @Component(modules = {AppModule.class}) public interface MainComponent {
  void inject(MainActivity activity);
}
