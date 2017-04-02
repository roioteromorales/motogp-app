package com.roisoftstudio.motogpfantasy.infrastructure.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.roisoftstudio.motogpfantasy.data.api.GrandPrixApi;
import com.roisoftstudio.motogpfantasy.data.api.LoginApi;
import com.roisoftstudio.motogpfantasy.data.api.MySelectionApi;
import com.roisoftstudio.motogpfantasy.data.api.RaceResultsApi;
import com.roisoftstudio.motogpfantasy.data.api.ScoresApi;
import com.roisoftstudio.motogpfantasy.data.persistance.AppPreferences;
import com.roisoftstudio.motogpfantasy.data.repository.ApiAuthRepository;
import com.roisoftstudio.motogpfantasy.data.repository.SharedPreferencesSessionRepository;
import com.roisoftstudio.motogpfantasy.domain.repository.AuthRepository;
import com.roisoftstudio.motogpfantasy.domain.repository.SessionRepository;
import com.roisoftstudio.motogpfantasy.infrastructure.okhttp.BasicAuthorizationHeaderInterceptor;
import com.roisoftstudio.motogpfantasy.infrastructure.okhttp.TokenAuthorizationHeaderInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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
    public OkHttpClient provideOkHttpClient(BasicAuthorizationHeaderInterceptor basicAuthorizationHeaderInterceptor, TokenAuthorizationHeaderInterceptor tokenAuthorizationHeaderInterceptor) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(basicAuthorizationHeaderInterceptor)
                .addInterceptor(tokenAuthorizationHeaderInterceptor)
                .addInterceptor(loggingInterceptor)
                .build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.172:8080/")
                .client(okHttpClient)
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
    public ScoresApi provideScoresApi(Retrofit retrofit) {
        return retrofit.create(ScoresApi.class);
    }

    @Provides
    @Singleton
    public MySelectionApi provideMySelectionApi(Retrofit retrofit) {
        return retrofit.create(MySelectionApi.class);
    }

    @Provides
    @Singleton
    public LoginApi provideLoginApi(Retrofit retrofit) {
        return retrofit.create(LoginApi.class);
    }

    @Provides
    @Singleton
    public AuthRepository provideAuthRepository(LoginApi loginApi) {
        return new ApiAuthRepository(loginApi);
    }

    @Provides
    @Singleton
    public RaceResultsApi provideRaceResultsApi(Retrofit retrofit) {
        return retrofit.create(RaceResultsApi.class);
    }

    @Provides
    @Singleton
    public SessionRepository provideSessionRepository(AppPreferences appPreferences) {
        return new SharedPreferencesSessionRepository(appPreferences);
    }


}
