package com.roisoftstudio.motogpfantasy.ui;

import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

import com.roisoftstudio.motogpfantasy.domain.model.GrandPrix;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetGrandPrixCallback implements Callback<List<GrandPrix>> {
    private static final String TAG = "GetGrandPrixCallback";

    private View view;

    public GetGrandPrixCallback(View view) {
        this.view = view;
    }

    @Override
    public void onResponse(Call<List<GrandPrix>> call, Response<List<GrandPrix>> response) {
        String message = "";
        if (response.isSuccessful()) {
            message = response.body().get(0).getDescription();
        } else {
            try {
                message = response.errorBody().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void onFailure(Call<List<GrandPrix>> call, Throwable t) {
        Log.e(TAG, t.getMessage() + ":", t);
        Snackbar.make(view, "Error: " + t.getMessage(), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
