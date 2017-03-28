package com.roisoftstudio.motogpfantasy.ui.myselection;

import android.util.Log;

import com.roisoftstudio.motogpfantasy.domain.model.MySelection;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MySelectionCallback implements Callback<MySelection> {
    private static final String TAG = "DashboardScoresCallback";

    private MySelectionPresenter.View view;

    public MySelectionCallback(MySelectionPresenter.View view) {
        this.view = view;
    }

    @Override
    public void onResponse(Call<MySelection> call, Response<MySelection> response) {
        String message = "MySelection Success";
        if (response.isSuccessful()) {
            MySelection mySelection = response.body();
            view.showMySelection(mySelection);
        } else {
            try {
                message = response.errorBody().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        view.showError(message);
    }

    @Override
    public void onFailure(Call<MySelection> call, Throwable t) {
        Log.v(TAG, t.getMessage() + ":", t);
        view.showError(t.getMessage());
    }
}
