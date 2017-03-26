package com.roisoftstudio.motogpfantasy.ui.dashboard.scores;

import android.util.Log;

import com.roisoftstudio.motogpfantasy.domain.model.Score;
import com.roisoftstudio.motogpfantasy.ui.dashboard.DashboardPresenter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetScoresCallback implements Callback<List<Score>> {
    private static final String TAG = "GetScoresCallback";

    private DashboardPresenter.View dashboardView;

    public GetScoresCallback(DashboardPresenter.View dashboardView) {
        this.dashboardView = dashboardView;
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
        dashboardView.showError(message);
    }

    @Override
    public void onFailure(Call<List<Score>> call, Throwable t) {
        Log.v(TAG, t.getMessage() + ":", t);
        dashboardView.showError(t.getMessage());
    }
}
