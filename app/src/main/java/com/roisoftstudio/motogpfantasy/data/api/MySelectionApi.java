package com.roisoftstudio.motogpfantasy.data.api;

import com.roisoftstudio.motogpfantasy.domain.model.Category;
import com.roisoftstudio.motogpfantasy.domain.model.MySelection;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MySelectionApi {
    @GET("selection/category/{category}/")
    Call<MySelection> getMySelection(@Path("category") Category category);
}
