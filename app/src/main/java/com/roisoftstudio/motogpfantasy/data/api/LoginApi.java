package com.roisoftstudio.motogpfantasy.data.api;

import com.roisoftstudio.motogpfantasy.domain.model.AuthToken;
import com.roisoftstudio.motogpfantasy.domain.model.LoginCredentials;
import com.roisoftstudio.motogpfantasy.domain.model.Score;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LoginApi {
    @POST("login/")
    Call<AuthToken> login(@Body LoginCredentials loginRequestApiModel);
}
