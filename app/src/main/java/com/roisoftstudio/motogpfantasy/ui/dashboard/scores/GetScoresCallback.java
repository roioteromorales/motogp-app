package com.roisoftstudio.motogpfantasy.ui.dashboard.scores;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.roisoftstudio.motogpfantasy.domain.model.Score;
import com.roisoftstudio.motogpfantasy.ui.dashboard.DashboardPresenter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetScoresCallback implements Callback<List<Score>> {
    private static final String TAG = "GetScoresCallback";

    private View view;
    private DashboardPresenter.View dashboardView;

    public GetScoresCallback(DashboardPresenter.View dashboardView ,View view) {
        this.dashboardView = dashboardView;
        this.view = view;
    }

    @Override
    public void onResponse(Call<List<Score>> call, Response<List<Score>> response) {
        String message = "GetScoresCallback - Success";
        if (response.isSuccessful()) {
            dashboardView.showScores(response.body());
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
    public void onFailure(Call<List<Score>> call, Throwable t) {
        Log.v(TAG, t.getMessage() + ":", t);
        Snackbar.make(view, "Error: " + t.getMessage(), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
