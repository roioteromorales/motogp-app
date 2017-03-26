package com.roisoftstudio.motogpfantasy.data.repository;

import com.roisoftstudio.motogpfantasy.data.api.LoginApi;
import com.roisoftstudio.motogpfantasy.domain.model.AuthToken;
import com.roisoftstudio.motogpfantasy.domain.model.LoginCredentials;
import com.roisoftstudio.motogpfantasy.domain.repository.AuthRepository;
import com.roisoftstudio.motogpfantasy.ui.login.LoginCallback;

import java.io.IOException;

import javax.inject.Inject;
import javax.security.auth.login.LoginException;

import retrofit2.Response;

public class ApiAuthRepository implements AuthRepository {

    private final LoginApi loginApi;

    @Inject
    public ApiAuthRepository(LoginApi loginApi) {
        this.loginApi = loginApi;
    }

    @Override
    public AuthToken getAuthToken(LoginCallback loginCallback, LoginCredentials credentials) throws LoginException {
        Response<AuthToken> response;
        try {
            response = loginApi.login(credentials).execute();
        } catch (IOException e) {
            throw new LoginException(e.getMessage());
        }

        if (response.isSuccessful()) {
            return response.body();
        } else {
            String errorMessage = "";
            try {
                errorMessage = response.errorBody().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            throw new LoginException(errorMessage);
        }
    }
}
