package com.roisoftstudio.motogpfantasy.datasource.api;

import com.roisoftstudio.motogpfantasy.domain.model.GrandPrix;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GrandPrixApi {
    @GET("gp/year/{year}")
    Call<List<GrandPrix>> list(@Path("year") String year);
}
