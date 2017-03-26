package com.roisoftstudio.motogpfantasy.infrastructure;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.roisoftstudio.motogpfantasy.data.api.GrandPrixApi;
import com.roisoftstudio.motogpfantasy.data.api.RaceResultsApi;
import com.roisoftstudio.motogpfantasy.data.api.ScoresApi;
import com.roisoftstudio.motogpfantasy.data.persistance.AppPreferences;
import com.roisoftstudio.motogpfantasy.data.repository.SharedPreferencesSessionRepository;
import com.roisoftstudio.motogpfantasy.domain.repository.AuthRepository;
import com.roisoftstudio.motogpfantasy.data.repository.InMemoryAuthRepository;
import com.roisoftstudio.motogpfantasy.domain.repository.SessionRepository;
import com.roisoftstudio.motogpfantasy.domain.service.GrandPrixService;
import com.roisoftstudio.motogpfantasy.domain.service.ScoresService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    private static final String PREF_NAME = "MOTOGP_FANTASY_PREFERENCES";
    private Application app;

    public AppModule(Application app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.172:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    @Singleton
    @Provides
    public SharedPreferences getAppPreferences() {
        return app.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    public GrandPrixApi provideGrandPrixApi(Retrofit retrofit) {
        return retrofit.create(GrandPrixApi.class);
    }

    @Provides
    @Singleton
    public GrandPrixService provideGrandPrixService(GrandPrixApi grandPrixApi) {
        return new GrandPrixService(grandPrixApi);
    }

    @Provides
    @Singleton
    public ScoresApi provideScoresApi(Retrofit retrofit) {
        return retrofit.create(ScoresApi.class);
    }


    @Provides
    @Singleton
    public RaceResultsApi provideRaceResultsApi(Retrofit retrofit) {
        return retrofit.create(RaceResultsApi.class);
    }

    @Provides
    @Singleton
    public ScoresService provideScoreService(ScoresApi scoresApi) {
        return new ScoresService(scoresApi);
    }
    @Provides
    @Singleton
    public SessionRepository provideSessionRepository(AppPreferences appPreferences) {
        return new SharedPreferencesSessionRepository(appPreferences);
    }

    @Provides
    @Singleton
    public AuthRepository provideAuthRepository() {
        return new InMemoryAuthRepository();
    }
}
