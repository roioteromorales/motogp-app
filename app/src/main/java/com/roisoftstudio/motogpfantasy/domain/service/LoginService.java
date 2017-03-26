package com.roisoftstudio.motogpfantasy.domain.service;

import com.roisoftstudio.motogpfantasy.data.api.LoginApi;
import com.roisoftstudio.motogpfantasy.domain.model.AuthToken;
import com.roisoftstudio.motogpfantasy.domain.model.LoginCredentials;
import com.roisoftstudio.motogpfantasy.domain.repository.AuthRepository;
import com.roisoftstudio.motogpfantasy.domain.repository.SessionRepository;
import com.roisoftstudio.motogpfantasy.ui.login.LoginCallback;

import javax.inject.Inject;
import javax.security.auth.login.LoginException;

public class LoginService {

    private final LoginApi loginApi;
    private final SessionRepository sessionRepository;

    @Inject
    public LoginService(LoginApi loginApi, SessionRepository sessionRepository) {
        this.loginApi = loginApi;
        this.sessionRepository = sessionRepository;
    }

    public void login(LoginCallback loginCallback, LoginCredentials credentials) {
        loginApi.login(credentials).enqueue(loginCallback);
    }

    public void logout() {
        sessionRepository.cleanSession();
    }
}
