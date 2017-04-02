package com.roisoftstudio.motogpfantasy.data.api;

import com.roisoftstudio.motogpfantasy.domain.model.Category;
import com.roisoftstudio.motogpfantasy.domain.model.Selection;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SelectionApi {
    @GET("selection/category/{category}/")
    Call<Selection> getMySelection(@Path("category") Category category);

    @POST("selection/category/{category}/")
    Call<Selection> saveMySelection(@Body Selection selection, @Path("category") Category category);
}
