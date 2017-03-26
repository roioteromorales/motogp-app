package com.roisoftstudio.motogpfantasy.data.repository;

import com.roisoftstudio.motogpfantasy.domain.model.AuthToken;
import com.roisoftstudio.motogpfantasy.domain.model.LoginCredentials;
import com.roisoftstudio.motogpfantasy.domain.repository.AuthRepository;
import com.roisoftstudio.motogpfantasy.infrastructure.qualifier.Stubs;
import com.roisoftstudio.motogpfantasy.ui.login.LoginCallback;

import javax.security.auth.login.LoginException;

public class InMemoryAuthRepository implements AuthRepository {

    @Override
    public AuthToken getAuthToken(LoginCallback loginCallback, LoginCredentials credentials) throws LoginException {
        if (credentials.email().toLowerCase().equals("roi")) {
            return new AuthToken("valid");
        } else {
            throw new LoginException();
        }
    }
}
