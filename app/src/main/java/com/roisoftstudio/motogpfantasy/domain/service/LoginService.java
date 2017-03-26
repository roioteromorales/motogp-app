package com.roisoftstudio.motogpfantasy.domain.service;

import com.roisoftstudio.motogpfantasy.domain.model.AuthToken;
import com.roisoftstudio.motogpfantasy.domain.model.LoginCredentials;
import com.roisoftstudio.motogpfantasy.domain.repository.AuthRepository;
import com.roisoftstudio.motogpfantasy.domain.repository.SessionRepository;

import javax.inject.Inject;
import javax.security.auth.login.LoginException;

public class LoginService {

    private final AuthRepository authRepository;
    private final SessionRepository sessionRepository;

    @Inject
    public LoginService(AuthRepository authRepository, SessionRepository sessionRepository) {
        this.authRepository = authRepository;
        this.sessionRepository = sessionRepository;
    }

    public void login(LoginCredentials credentials) throws LoginException {
        AuthToken authToken = authRepository.getAuthToken(credentials);
        sessionRepository.createSession(authToken);
    }
}
