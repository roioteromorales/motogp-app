package com.roisoftstudio.motogpfantasy.infrastructure.okhttp;

import com.roisoftstudio.motogpfantasy.domain.model.AuthToken;
import com.roisoftstudio.motogpfantasy.domain.repository.SessionRepository;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenAuthorizationHeaderInterceptor implements Interceptor {

    private SessionRepository sessionRepository;

    @Inject
    public TokenAuthorizationHeaderInterceptor(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request newRequest = chain.request().newBuilder().addHeader("X-Authorization", getToken()).build();
        return chain.proceed(newRequest);
    }

    private String getToken() {
        AuthToken sessionToken = sessionRepository.getSessionToken();
        if (sessionToken != null) {
            return sessionToken.getToken();
        } else {
            return "";
        }
    }
}
