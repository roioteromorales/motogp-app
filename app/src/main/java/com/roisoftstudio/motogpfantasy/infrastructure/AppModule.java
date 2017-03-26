package com.roisoftstudio.motogpfantasy.infrastructure;

import com.roisoftstudio.motogpfantasy.data.api.GrandPrixApi;
import com.roisoftstudio.motogpfantasy.data.api.ScoresApi;
import com.roisoftstudio.motogpfantasy.data.repository.InMemorySessionRepository;
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

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.172:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
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
    public ScoresService provideScoreService(ScoresApi scoresApi) {
        return new ScoresService(scoresApi);
    }
    @Provides
    @Singleton
    public SessionRepository provideSessionRepository() {
        return new InMemorySessionRepository();
    }
}
