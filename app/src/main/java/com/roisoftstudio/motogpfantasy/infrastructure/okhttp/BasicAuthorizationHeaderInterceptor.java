package com.roisoftstudio.motogpfantasy.infrastructure.okhttp;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class BasicAuthorizationHeaderInterceptor implements Interceptor {

    private static final String HEADER_CLIENT_TOKEN = "Basic 123";

    @Inject
    public BasicAuthorizationHeaderInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request newRequest = chain.request().newBuilder().addHeader("Authorization", HEADER_CLIENT_TOKEN).build();
        return chain.proceed(newRequest);
    }
}
