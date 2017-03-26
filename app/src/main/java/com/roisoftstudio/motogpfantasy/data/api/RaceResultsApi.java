package com.roisoftstudio.motogpfantasy.data.api;

import com.roisoftstudio.motogpfantasy.domain.model.RaceResult;
import com.roisoftstudio.motogpfantasy.domain.model.Score;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RaceResultsApi {
    @GET("results/current/{category}")
    Call<List<RaceResult>> getRaceResults(@Path("category") String category);
}
