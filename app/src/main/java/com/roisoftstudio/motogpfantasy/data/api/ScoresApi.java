package com.roisoftstudio.motogpfantasy.data.api;

import com.roisoftstudio.motogpfantasy.domain.model.Score;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ScoresApi {
    @GET("scores/")
    Call<List<Score>> getAll();
}
