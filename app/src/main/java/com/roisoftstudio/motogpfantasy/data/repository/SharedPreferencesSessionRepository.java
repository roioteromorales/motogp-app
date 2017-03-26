package com.roisoftstudio.motogpfantasy.data.repository;

import com.roisoftstudio.motogpfantasy.data.persistance.AppPreferences;
import com.roisoftstudio.motogpfantasy.domain.model.AuthToken;
import com.roisoftstudio.motogpfantasy.domain.repository.SessionRepository;

import javax.inject.Inject;

public class SharedPreferencesSessionRepository implements SessionRepository {

    private final AppPreferences appPreferences;

    @Inject
    public SharedPreferencesSessionRepository(AppPreferences appPreferences) {
        this.appPreferences = appPreferences;
    }

    @Override
    public void createSession(AuthToken token) {
        appPreferences.write(token.getToken());
    }

    @Override
    public void cleanSession() {
        appPreferences.write(null);
    }

    @Override
    public AuthToken getSessionToken() {
        String tokenValue = appPreferences.read();
        if ("valid".equals(tokenValue)) {
            return new AuthToken(tokenValue);
        } else {
            return new AuthToken("");
        }
    }


}
